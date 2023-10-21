package password;

import java.util.Arrays;

public enum PasswordStrength {
    WEAK(1L),
    NORMAL(2L),
    STRONG(3L);

    private final long numberOfMatches;

    PasswordStrength(final long numberOfMatches) {
        this.numberOfMatches = numberOfMatches;
    }

    public static PasswordStrength of(final long numberOfMatches) {
        return Arrays.stream(values())
                .filter(strength -> strength.equalToMatchCount(numberOfMatches))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    private boolean equalToMatchCount(final long numsRuleSatisfies) {
        return this.numberOfMatches == numsRuleSatisfies;
    }
}
