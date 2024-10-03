package assignment6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

class Policy {
	private String policyNumber;
	private String holderName;
	private double premiumAmount;

	public Policy(String policyNumber, String holderName, double premiumAmount) {
		this.policyNumber = policyNumber;
		this.holderName = holderName;
		this.premiumAmount = premiumAmount;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public String getHolderName() {
		return holderName;
	}

	public double getPremiumAmount() {
		return premiumAmount;
	}

	@Override
	public String toString() {
		return "Policy [policyNumber=" + policyNumber + ", holderName=" + holderName + ", premiumAmount="
				+ premiumAmount + "]";
	}

}

public class Program11 {

	public static void main(String[] args) {
		List<Policy> policies = new ArrayList<>(Arrays.asList(new Policy("P001", "Aarav", 1500.00),
				new Policy("P002", "Vihaan", 2500.00), new Policy("P003", "Reyansh", 2000.00),
				new Policy("P004", "Krishna", 800.00), new Policy("P005", "Aarav", 1700.00)));

		List<Double> premiumAmountGreaterThan1200 = policies.stream().filter(x -> x.getPremiumAmount() >= 1200)
				.map(Policy::getPremiumAmount).collect(Collectors.toList());
		System.out.println("Premium amounts greater than 1200: " + premiumAmountGreaterThan1200);

		List<String> sortedHolderNames = policies.stream().map(Policy::getHolderName).sorted()
				.collect(Collectors.toList());

		System.out.println("Sorted Holder Names: " + sortedHolderNames);
		Double totalPremiumAmount = policies.stream().mapToDouble(Policy::getPremiumAmount).sum();
		System.out.println("Total Premium Amount: " + totalPremiumAmount);

		policies.forEach(policy -> System.out.printf("Policy Number: %s, Holder Name: %s, Premium Amount: %.2f%n",
				policy.getPolicyNumber(), policy.getHolderName(), policy.getPremiumAmount()));
		List<Policy> filteredPolicies = policies.stream()
				.filter(policy -> policy.getPremiumAmount() >= 1000 && policy.getPremiumAmount() <= 2000)
				.collect(Collectors.toList());
		System.out.println(filteredPolicies);

		Optional<Policy> highestPremiumPolicy = policies.stream()
				.max(Comparator.comparingDouble(Policy::getPremiumAmount));
		highestPremiumPolicy.ifPresent(policy -> System.out.printf(
				"Policy with Highest Premium: Policy Number: %s, Holder Name: %s, Premium Amount: %.2f%n",
				policy.getPolicyNumber(), policy.getHolderName(), policy.getPremiumAmount()));

		Map<Character, List<Policy>> groupedPolicies = policies.stream()
				.collect(Collectors.groupingBy(policy -> policy.getHolderName().charAt(0)));

		groupedPolicies.forEach((initial, policyList) -> {
			System.out.printf("Policies with holder names starting with '%c':%n", initial);
			policyList.forEach(
					policy -> System.out.printf("    Policy Number: %s, Holder Name: %s, Premium Amount: %.2f%n",
							policy.getPolicyNumber(), policy.getHolderName(), policy.getPremiumAmount()));
		});
		OptionalDouble average = policies.stream().mapToDouble(Policy::getPremiumAmount).average();

		if (average.isPresent()) {
			System.out.printf("Average Premium Amount: %.2f%n", average.getAsDouble());
		} else {
			System.out.println("No policies available to calculate the average.");
		}
		System.out.println("Policies sorted by premium amount (ascending):");
		policies.stream().sorted((p1, p2) -> Double.compare(p1.getPremiumAmount(), p2.getPremiumAmount()))
				.forEach(policy -> System.out.printf("Policy Number: %s, Holder Name: %s, Premium Amount: %.2f%n",
						policy.getPolicyNumber(), policy.getHolderName(), policy.getPremiumAmount()));
		boolean hasHighPremiumPolicy = policies.stream().anyMatch(policy -> policy.getPremiumAmount() > 2000);

		if (hasHighPremiumPolicy) {
			System.out.println("There is at least one policy with a premium amount greater than $2,000.");
		} else {
			System.out.println("No policies exceed a premium amount of $2,000.");
		}
		long countLow = policies.stream()
				.filter(policy -> policy.getPremiumAmount() >= 0 && policy.getPremiumAmount() <= 1000).count();

		long countMid = policies.stream()
				.filter(policy -> policy.getPremiumAmount() > 1000 && policy.getPremiumAmount() <= 2000).count();

		long countHigh = policies.stream().filter(policy -> policy.getPremiumAmount() > 2000).count();

		System.out.println("Number of policies with premium between $0-$1,000: " + countLow);
		System.out.println("Number of policies with premium between $1,001-$2,000: " + countMid);
		System.out.println("Number of policies with premium greater than $2,000: " + countHigh);
		List<String> uniqueHolderNames = policies.stream().map(Policy::getHolderName).distinct()
				.collect(Collectors.toList());

		System.out.println("Unique Holder Names: " + uniqueHolderNames);
		
		 String substring = "an";
	        List<Policy> matchingPolicies = policies.stream()
	                .filter(policy -> policy.getHolderName().contains(substring))
	                .collect(Collectors.toList());
	        System.out.println("Policies where holder's name contains '" + substring + "':");
	        System.out.println(matchingPolicies);
	        
	        Map<String, Double> policyPremiumMap = policies.stream()
	                .collect(Collectors.toMap(
	                    Policy::getPolicyNumber,      
	                    Policy::getPremiumAmount      
	                ));

	      
	        System.out.println("Policy Number to Premium Amount Map:");
	        policyPremiumMap.forEach((policyNumber, premiumAmount) -> 
	            System.out.println("Policy Number: " + policyNumber + ", Premium Amount: " + premiumAmount)
	        );
	}
}
