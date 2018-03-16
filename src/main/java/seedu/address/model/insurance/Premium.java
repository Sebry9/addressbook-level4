package seedu.address.model.insurance;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;


/**
 * Represents a Insurance's monthly premium price
 * Guarantees: immutable; is valid as declared in {@link #isValidPremium(String)}
 */

public class Premium {
    public static final String MESSAGE_PREMIUM_CONSTRAINTS = "Premium can only contain numbers";
    public static final String PREMIUM_VALIDATION_REGEX = "\\d";
    public final String value;

    /**
     * Constructs a {@code Phone}.
     *
     * @param monthlyPremium A valid monthlyPremium.
     */
    public Premium(String monthlyPremium) {
        requireNonNull(monthlyPremium);
        checkArgument(isValidPremium(monthlyPremium), MESSAGE_PREMIUM_CONSTRAINTS);
        this.value = monthlyPremium;
    }

    /**
     * Returns true if a given string is a valid person phone number.
     */
    public static boolean isValidPremium(String test) {
        return test.matches(PREMIUM_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Premium // instanceof handles nulls
                && this.value.equals(((Premium) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
