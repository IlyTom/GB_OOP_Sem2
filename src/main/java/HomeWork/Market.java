package HomeWork;

import java.util.*;

public class Market implements MarketBehaviour,QueueBehaviour{
    List<Actor> actors = new LinkedList<>();
    Queue<Actor> actorQueue = new ArrayDeque<>();

    @Override
    public void acceptToMarket(Actor actor) {
        System.out.println(actor.getName() + " зашел в магазин");
        actors.add(actor);
    }

    @Override
    public void releaseFromMarket(Actor actor) {
        actors.remove(actor);
        System.out.println(actor.getName() + " покинул магазин");
    }

    @Override
    public void update() {
    }

    @Override
    public void takeInQueue(Actor actor) {
        actorQueue.add(actor);
        System.out.println(actor.getName() + " встал в очередь");
    }

    @Override
    public void takeOrders() {
        actorQueue.peek().isTakeOrder();
        System.out.println(actorQueue.peek().getName()+" забрал заказ");
    }

    @Override
    public void giveOrders() {
        actorQueue.peek().isMakeOrder();
        System.out.println(actorQueue.peek().getName()+ " сделал заказ");
    }

    @Override
    public void releaseFromQueue() {
        System.out.println(actorQueue.peek().getName()+ " покинул очередь");
        actorQueue.poll();
    }
}
