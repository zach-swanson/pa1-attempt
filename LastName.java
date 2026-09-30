boolean isValidLastName(String name) {
    // A valid last name has at least two characters.
    // It is alphabetical, except for a single hyphen or apostrophe,
    // which cannot be the first or last character.
    // The first letter is always capitalized, as are any letters
    // following a hyphen or apostrophe. The rest are lowercase.

    // this would return a false negative for the valid last name McDonald.
    // This would return a (presumably) false negative for any last name that is
    // just a series of letters like Abcdefghik, but checking that case would require
    // essentially a complete list of valid names.

    // I wrote the above comment (not counting the false positive/negatives) and told Copilot to finish the program.
    // It noodled for a while trying to do it with regex before doing it manually as seen here.
    if (name == null || name.length() < 2) {
        return false;
    }

    int separatorIndex = -1;
    for (int i = 0; i < name.length(); i++) {
        char ch = name.charAt(i);
        if (ch == '-' || ch == '\'') {
            if (i == 0 || i == name.length() - 1 || separatorIndex != -1) {
                return false;
            }
            separatorIndex = i;
        } else if ((ch < 'A' || ch > 'Z') && (ch < 'a' || ch > 'z')) {
            return false;
        }
    }

    if (separatorIndex == -1) {
        if (name.charAt(0) < 'A' || name.charAt(0) > 'Z') {
            return false;
        }
        for (int i = 1; i < name.length(); i++) {
            char ch = name.charAt(i);
            if (ch < 'a' || ch > 'z') {
                return false;
            }
        }
        return true;
    }

    String first = name.substring(0, separatorIndex);
    String second = name.substring(separatorIndex + 1);

    if (first.length() < 1 || second.length() < 1) {
        return false;
    }
    if (first.charAt(0) < 'A' || first.charAt(0) > 'Z') {
        return false;
    }
    if (second.charAt(0) < 'A' || second.charAt(0) > 'Z') {
        return false;
    }
    for (int i = 1; i < first.length(); i++) {
        char ch = first.charAt(i);
        if (ch < 'a' || ch > 'z') {
            return false;
        }
    }
    for (int i = 1; i < second.length(); i++) {
        char ch = second.charAt(i);
        if (ch < 'a' || ch > 'z') {
            return false;
        }
    }
    return true;
}

void main() {
    assert isValidLastName("Smith");
    assert isValidLastName("O'Neil");
    assert isValidLastName("Smith-Jones");
    assert isValidLastName("A-B");
    assert !isValidLastName("smith");
    assert !isValidLastName("O'neil");
    assert !isValidLastName("O-");
    assert !isValidLastName("O''Neil");
    assert !isValidLastName("O-Neil-Jones");
}