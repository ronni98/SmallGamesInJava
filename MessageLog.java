import java.util.*;


/* 
   Message has the format nodeId:description and exactly one ":" appears in a message.
   nodeId is a computer (e.g., Server2) or a user (e.g., Client8).
   There are no spaces immediately before or after ":".
*/

class Message {
    String nodeId;
    String description;

    public Message(String msg_str) {
        String[] wa = msg_str.split(":");
        nodeId = wa[0];
        description = wa[1];
    }

    /*
     * returns: true if description contains the keyword false otherwise The keyword
     * is either at the beginning or it is immediately preceded by a space. The
     * keyword is either at the end or it is immediately followed by a space.
     */
    public boolean contains_word(String keyword, boolean case_sensitive) {
        String[] wa = description.split(" ");
        for (String d : wa) {
            if (str_eq(d, keyword, case_sensitive)) {
                return true;
            }
        }

        return false;
    }

    boolean str_eq(String w1, String w2, boolean case_sensitive) {
        if (case_sensitive) {
            return w1.equals(w2);
        }
        return w1.equalsIgnoreCase(w2);
    }

    public boolean contains_segment(String[] segment, boolean case_sensitive) {
        String[] wa = description.split("[ ]+"); // regular expression: *: >= 0, +: >= 1, ?: 0 or 1
        int len = segment.length;
        for (int k = 0; k <= wa.length - len; k++) { // k: index of wa
            boolean match = true;
            for (int j = 0; j < segment.length; j++) { // j: index of segment
                String w1 = wa[k + j];  // w1: word from the message
                String w2 = segment[j];
                if (!str_eq(w1, w2, case_sensitive)) {
                    match = false;
                    break;
                }
            }

            if (match) {
                return true;
            }
        }
        return false;
    }
}

public class MessageLog {
    public static void main(String[] args) {
        // a log
        String[] log = {
            "Server7:Client2 new account is saved",
            "Server6:Client8 new  account is saved",
            "Server8:Client2 login",
            "Server1:disk",
            "Server2:Disk",
            "Server3:error on disk",
            "Server4:error on disk3",
            "Server9:error on /dev/disk",
            "Server5:error on /dev/disk disk",
            "Server6:error on disk DSK2",
            "Server1:disks", "Server4:Client3 submit order 1",
            "Server9:Client3 add product 2 to shopping cart",
            "Server9:Client3 add product 2 to shopping  cart",
            "Client5:security alert - repeated login failures",
            "Webserver:disk is available",
            "Server1:file X is not found",
            "Server4:DISK is full",
            "Server1:file Y is not  found",
            "Server3:read error on disk DSK1",
            "Server1:write Error on disk DSK2",
            "Server9:Write Error on DISK",
            "Webserver:error on /dev/disk" };

        int n = log.length;
        Message[] msg = new Message[n];
        for (int k = 0; k < log.length; k++) {
            msg[k] = new Message(log[k]);
            /*
             * System.out.println("message " + k + " : nodeId=" + msg[k].nodeId +
             * "  description=" + msg[k].description);
             */
        }

        List<String> res = search(msg, "disk", false);
        display(res);
        

        List<String> res2 = search_segment(msg, "new account", false); display(res2);
        List<String> res3 = search_segment(msg, "shopping cart", false); display(res3);
        res3 = search_segment(msg, "error on disk", false); display(res3);

    }

    static List<String> search_segment(Message[] msg, String phrase, boolean case_sensitive) {
        String[] segment = phrase.split(" ");
        List<String> res = new ArrayList<>();
        for (Message y : msg) {
            if (y.contains_segment(segment, case_sensitive)) {
                res.add(y.description);
            }
        }

        return res;
    }

    static List<String> search(Message[] msg, String keyword, boolean case_sensitive) {
        List<String> res = new ArrayList<>();
        for (Message y : msg) {
            if (y.contains_word(keyword, case_sensitive)) {
                res.add(y.description);
            }
        }

        return res;
    }

    static void display(List<String> res) {
        for (String d : res) {
            System.out.println(d);
        }
        System.out.println();
    }
}
