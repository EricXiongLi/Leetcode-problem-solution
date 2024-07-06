class Solution {
    public String validIPAddress(String queryIP) {
        String[] ip4s = queryIP.split("\\.", -1);
        String[] ip6s = queryIP.split(":", -1);
        
        if (is4(ip4s)) {
            return "IPv4";
        } else if (is6(ip6s)) {
            return "IPv6";
        }
        
        return "Neither";
    }
    
    public boolean is6(String[] ips) {
        if (ips.length != 8) {
            return false;
        }
        for (String s : ips) {
            if (!isIPv6(s)) {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean is4(String[] ips) {
        
        if (ips.length != 4) {
            return false;
        }
        for (String s : ips) {
            if (!isIPv4(s)) {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean isIPv4(String ip) {
        try {
            //005
            int value = Integer.parseInt(ip);
            if (String.valueOf(value).equals(ip) && value >= 0 && value <= 255) {
                return true;
            }
        } catch(NumberFormatException e) {
            return false;
        }
        return false;
    }
    
    public boolean isIPv6(String s) {
        
        try {
            if (1 <= s.length() && s.length() <= 4 && Integer.valueOf(s, 16) >= 0) {
                return true;
            }
        } catch(NumberFormatException e) {
            return false;
        }
        return false;
    }
}

//tc: O(N)
//sc: O(N)