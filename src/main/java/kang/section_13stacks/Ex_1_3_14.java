package kang.section_13stacks;

/**
 * Develop a class {@link ResizingArrayQueueOfStrings} that implements the queue abstraction with
 * a fixed-size array, and then extend your implementation to use array resizing to remove the
 * size restriction.
 */
public class Ex_1_3_14 {
    public static void main(String[] args) {
        ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings();
        queue.enqueue("Hello");
        queue.enqueue("World");
        queue.enqueue("Hello");
        queue.enqueue("World");
        queue.enqueue("World");
        System.out.println(queue);


        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue);
        System.out.println(queue.size());

    }
}
