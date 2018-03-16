package seedu.address.model.insurance;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;


/**
 * Represents a Insurance in reInsurance.
 * Guarantees: details all present and not null
 */
public class Insurance {
    private final Name insuranceName;
    private final Commission commission;
    private final Premium monthlyPremium;


    /**
     * Constructs a {@code Tag}.
     *
     * Every field must be present and not null
     */
    public Insurance(Name insuranceName, Commission commission, Premium monthlyPremium) {
        requireAllNonNull(insuranceName, commission, monthlyPremium);
        this.insuranceName = insuranceName;
        this.commission = commission;
        this.monthlyPremium = monthlyPremium;
    }


    public Name getInsuranceName() {
        return insuranceName;
    }

    public Commission getCommission() {
        return commission;
    }

    public Premium getMonthlyPremium() {
        return monthlyPremium;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Insurance)) {
            return false;
        }

        Insurance otherPerson = (Insurance) other;
        return otherPerson.getInsuranceName().equals(this.getInsuranceName())
                && otherPerson.getCommission().equals(this.getCommission())
                && otherPerson.getMonthlyPremium().equals(this.getMonthlyPremium());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(insuranceName, commission, monthlyPremium);
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(" Insurance Name: ")
                .append(getInsuranceName())
                .append(" Monthly Premium: ")
                .append(getMonthlyPremium())
                .append("(")
                .append(getCommission())
                .append(")");
        return builder.toString();
    }
}
