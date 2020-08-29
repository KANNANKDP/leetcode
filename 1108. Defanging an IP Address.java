class Solution1 {
    public String defangIPaddr(String address) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                str.append("[.]");
                continue;
            }
            str.append(address.charAt(i));
        }
        return str.toString();
    }
}

class Solution2 {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}

