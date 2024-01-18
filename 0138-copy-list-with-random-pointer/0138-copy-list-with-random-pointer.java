/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node temp = head;
        HashMap<Node, Node> map = new HashMap<>();
        while(temp != null){
            Node curr = new Node(temp.val);
            map.put(temp, curr);
            temp = temp.next;
        }
        temp = head;
        Node start = null;
        int f=0;
        while(temp != null){
            Node first = map.get(temp);
            map.get(temp).next = map.get(temp.next);
            map.get(temp).random = map.get(temp.random);
            if(f == 0){
                start = first;
                f=1;
            }
            temp = temp.next;
        }
        return start;
    }
}

// This Code works if all the node values are unique to each other.
/*class Solution {
    public Node copyRandomList(Node head) {
        Node temp = head;
        Node start = null;
        Node pointer = start;
        while(temp != null){
            Node curr = new Node(temp.val);
            if(start == null){
                start = curr;
                pointer = curr;
            }
            else{
                pointer.next = curr;
                pointer = pointer.next;
            }
            temp = temp.next;
        }
        pointer = start;
        Node curr = head;
        while(pointer != null){
            temp = curr;
            Node x = start;
            if(head.random != null){
                while(x != null){
                    if(x.val == head.random.val){
                        pointer.random = x;
                        break;
                    }
                    x = x.next;
                }
            }
            else
                pointer.random = null;

            pointer = pointer.next;
            head = head.next;
        }
        return start;
    }
}*/