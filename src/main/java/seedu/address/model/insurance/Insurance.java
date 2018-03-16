package seedu.address.model.insurance;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;


/**
 * Represents a Insurance in the address book.
 * Guarantees: immutable; name, commission, monthly premium is valid as declared in {@link #isValidInsuranceName(String)
 * @link #isValidComission(String), @link #isValidPremium(String)}
 */
public class Insurance {

    public static final String MESSAGE_INSURANCENAME_CONSTRAINTS = "Tags names should be alphanumeric";
    public static final String INSURANCE_VALIDATION_REGEX = "\\p{Alnum}+";
    public static final String MESSAGE_COMMISSION_CONSTRAINTS = "Comission can only contain numbers";
    public static final String COMMISSION_VALIDATION_REGEX = "\\d";
    public static final String MESSAGE_PREMIUM_CONSTRAINTS = "Monthly premium paid can only contain numbers";
    public static final String PREMIUM_VALIDATION_REGEX = "\\d";


    public final String insuranceName;
    public final String commission;
    public final String monthlyPremium;


    /**
     * Constructs a {@code Tag}.
     *
     * @param insuranceName a valid insurance
     * @param commission is valid amount
     * @param monthlyPremium is a valid amount
     */
    public Insurance(String insuranceName, String commission, String monthlyPremium) {
        requireAllNonNull(insuranceName, commission);
        checkArgument(isValidInsuranceName(insuranceName), MESSAGE_INSURANCENAME_CONSTRAINTS);
        this.insuranceName = insuranceName;
        checkArgument(isValidCommission(commission),MESSAGE_COMMISSION_CONSTRAINTS);
        this.commission = commission;
        checkArgument(isValidPremium(monthlyPremium),MESSAGE_PREMIUM_CONSTRAINTS);
        this.monthlyPremium = monthlyPremium;
    }

    private Boolean isValidPremium(String test) {
        return test.matches(PREMIUM_VALIDATION_REGEX);
    }


    private Boolean isValidCommission(String test) {
        return test.matches(COMMISSION_VALIDATION_REGEX);
    }

    /**
     * Returns true if a given string is a valid tag name.
     */
    public static boolean isValidInsuranceName(String test) {
        return test.matches(INSURANCE_VALIDATION_REGEX);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof seedu.address.model.insurance.Insurance // instanceof handles nulls
                && this.insuranceName.equals(((Insurance) other).insuranceName)); // state check
    }

    @Override
    public int hashCode() {
        return insuranceName.hashCode();
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        return '[' + insuranceName + ':' + monthlyPremium + '(' + commission + ')'+ ']';
    }

}
