public class LinkedList{
    public Node head;


    /* First Constructor:
     * Creates a linked list using the values from the given array. head will refer
     * to the Node that contains the element from a[0]
     */
    public LinkedList(Object [] a){
        head=new Node(a[0],null);
        Node tail=head;
        for(int i=1;i<a.length;i++){
            Node x=new Node(a[i],null);
            tail.next=x;
            tail=tail.next;
        }
    }

    /* Second Constructor:
     * Sets the value of head. head will refer
     * to the given LinkedList
     */
    public LinkedList(Node h){
        head = h;
    }

    /* Counts the number of Nodes in the list */
    public int countNode(){
        int count = 0;
        Node n = head;
        while(n!=null){
            count+=1;
            n=n.next;
        }
        return count;
    }

    /* prints the elements in the list */
    public void printList(){
        for(Node n = head; n!=null; n = n.next){
            if(n.next==null){
                System.out.print(n.element+".");
            }
            else{
                System.out.print(n.element+", ");
            }
        }
        System.out.println();
    }

    // returns the reference of the Node at the given index. For invalid index return null.
    public Node nodeAt(int idx){
        if(idx<0) return null;
        Node n = head;
        int i = 0;
        while(n!=null){
            if(i==idx) break;
            i++;
            n = n.next;
        }
        return n;
    }


    // returns the element of the Node at the given index. For invalid idx return null.
    public Object get(int idx){
        if(idx<0) return null;
        int i = 0;
        for(Node n = head; n!=null; n = n.next){
            if(i==idx) return n.element;
            i++;
        }
        return null;
    }



    /* updates the element of the Node at the given index.
     * Returns the old element that was replaced. For invalid index return null.
     * parameter: index, new element
     */
    public Object set(int idx, Object elem){
        Object oldElement = null;
        int i = 0;
        int count = 0;
        for(Node n = head; n!=null; n = n.next){
            count++;
        }
        if(idx<0 || idx>count) return null;
        for(Node n = head; n!=null; n = n.next){
            if(i==idx){
                oldElement = n.element;
                n.element = elem;
            }
            i++;
        }
        return oldElement;
    }


    /* returns the index of the Node containing the given element.
     if the element does not exist in the List, return -1.
     */
    public int indexOf(Object elem){
        int index = 0;
        for(Node n = head; n!=null; n = n.next){
            if(n.element==elem) return index;
            index++;
        }
        return -1;
    }

    // returns true if the element exists in the List, return false otherwise.
    public boolean contains(Object elem){
        Node n = head;
        while(n!=null){
            if(n.element==elem) return true;
            n = n.next;
        }
        return false;
    }

    // Makes a duplicate copy of the given List. Returns the reference of the duplicate list.
    public Node copyList(){
        Node copyHead = null, copyTail = null;
        for(Node n = head; n!=null; n=n.next){
            if(copyHead==null){
                copyHead = n;
                copyTail = copyHead;
            }
            else{
                copyTail.next = n;
                copyTail = copyTail.next;
            }
        }
        return copyHead;
    }

    // Makes a reversed copy of the given List. Returns the head reference of the reversed list.
    public Node reverseList(){
        Node reverseNode = null;
        for(Node n = head; n!=null; n = n.next){
            Node newNode = new Node(n.element, null);
            newNode.next = reverseNode;
            reverseNode  = newNode;
        }
        return reverseNode;
    }

    /* inserts Node containing the given element at the given index
     * Check validity of index.
     */
    public void insert(Object elem, int idx){
        if(idx<0) System.out.println("Give proper index.");
        Node element = new Node(elem, null);
        if(idx==0){
            element.next = head;
            head = element;
        }
        else{
            Node prev = nodeAt(idx-1);
            element.next = prev.next;
            prev.next = element;
        }
    }


    /* removes Node at the given index. returns element of the removed node.
     * Check validity of index. return null if index is invalid.
     */
    public Object remove(int index){
        if(index<0) return null;
        Object removed = null;
        Node removedNode = null;
        int i = 0;
        for(Node n = head; n!=null; n = n.next){
            if(index==0){
                removed = head.element;
                removedNode = head;
                head = head.next;
                removedNode.next = null;
            }
            else if(i==index){
                removed = n.element;
                Node prev = nodeAt(index-1);
                removedNode = prev.next;
                prev.next = removedNode.next;
                removedNode.next = null;
            }
            i++;
        }
        return removed;
    }

    // Rotates the list to the left by 1 position.
    public void rotateLeft(){
        Node oldHead = head;
        head = head.next;
        Node tail = head;
        while(tail.next!=null){
            tail = tail.next;
        }
        tail.next = oldHead;
        oldHead.next = null;
    }

    // Rotates the list to the right by 1 position.
    public void rotateRight(){
        Node newTail = null;
        Node newHead = head;
        while(newHead.next!=null){
            newTail = newHead;
            newHead = newHead.next;
        }
        newHead.next = head;
        head = newHead;
        newTail.next = null;
    }

}