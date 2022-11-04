package kang.section_13stacks;

/**
 * Write a Queue implementation that uses a circular linked list, which is the same as a linked
 * list except that no links are null and the value of last.next is first whenever the list is
 * not empty. Keep only on Node instance variable (last).
 */
public class Ex_1_3_29 {
    public static void main(String[] args) {
        CircularQueue<Integer> queue = new CircularQueue<>();
        queue.enqueue(1);
        System.out.println(queue);

        queue.enqueue(2);
        System.out.println(queue);

        queue.enqueue(3);
        System.out.println(queue);

        System.out.println(queue.dequeue());
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue);
    }
}
