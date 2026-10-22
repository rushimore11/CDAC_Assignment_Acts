package ADS.Q1;

public class MergeSortedLinkedList {
    public static DoublyLinkList mergeLinkList(DoublyLinkList list1,DoublyLinkList list2){
        DoublyLinkList mergedList = new DoublyLinkList();
        if(list1.head == null || list2.head == null){
            return mergedList;
        }
        DoublyLinkList.Node temp1 = list1.head ;
        DoublyLinkList.Node temp2 = list2.head;

        while(temp1 != null && temp2 != null){
            if(temp1.data >= temp2.data){
                mergedList.addNode(temp1.data);
                temp1 = temp1.next;
            }else{
                mergedList.addNode(temp2.data);
                temp2= temp2.next;
            }
        }

        while(temp1 != null){
            mergedList.addNode(temp1.data);
            temp1 = temp1.next;
        }

        while(temp2 != null){
            mergedList.addNode(temp2.data);
            temp2 = temp2.next;
        }

        return mergedList;

    }
    public static void main(String[] args) {
        DoublyLinkList list1 = new DoublyLinkList();
        list1.addNode(9);
        list1.addNode(7);
        list1.addNode(6);
        list1.addNode(2);

        DoublyLinkList list2 = new DoublyLinkList();
        list2.addNode(56);
        list2.addNode(1);
        list2.addNode(3);

        DoublyLinkList mergeList = mergeLinkList(list1,list2);
        mergeList.display();

    }

}
