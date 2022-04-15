package week07;

public interface QueueInterface<E> {
	public void enqueue(E x);
	public E dequeue();
	public E front();
	public boolean isEmpty();
	public void dequeueAll();
}  // ÄÚµå 7-1
