package com.amit.rxjava;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by amit on 22/6/16.
 */
public class AsyncHelper {

    Entity entity1 = new Entity("1","name1","1","1");
    Entity entity2 = new Entity("2","name2","1","2");
    Entity entity3 = new Entity("3","name3","1","3");
    Entity entity4 = new Entity("4","name4","2","4");
    Entity entity5 = new Entity("5","name5","2","1");
    Entity entity6 = new Entity("6","name6","3","5");

        List<Entity> entities = new ArrayList<>();


    public Observable<String> getObservable(String s){
        return Observable.create((Subscriber<? super String> a) -> {
            // simulate latency
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            a.onNext(s);
            a.onCompleted();
        });
    }
    public Observable<String> getObservableAsync(String s){
        return getObservable(s).subscribeOn(Schedulers.io());
    }

    public Observable<String> getListAsync(){

        List<String> stringList = new ArrayList();
        stringList.add("1");stringList.add("2");stringList.add("3");
        stringList.add("4");stringList.add("5");stringList.add("6");
        stringList.add("7");
        return  Observable.from(stringList).flatMap(new Func1<String, Observable<String>>() {
            @Override
            public Observable<String> call(String s) {
                return getObservableAsync(s);
            }
        });
    }
    public Observable<String> getListSync(){
        List<String> stringList = new ArrayList();
        stringList.add("1");stringList.add("2");stringList.add("3");
        stringList.add("4");stringList.add("5");stringList.add("6");
        stringList.add("7");
        return  Observable.from(stringList).flatMap(new Func1<String, Observable<String>>() {
            @Override
            public Observable<String> call(String s) {
                return getObservable(s);
            }
        });
    }

    private Observable<Integer> getDataAsync(int i) {
        return getDataSync(i).subscribeOn(Schedulers.io());
    }

    private Observable<Integer> getDataSync(int i) {
        System.out.println(i);
        return Observable.create((Subscriber<? super Integer> s) -> {
            // simulate latency
            try {

                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            s.onNext(i);
            s.onCompleted();
        });
    }

    private  void mergingAsync() {
        Observable.merge(getDataAsync(1), getDataAsync(2)).toBlocking().forEach(System.out::println);
    }


    public Observable<EntityStat> getEntityStat(String id){

        Observable<Integer> likes = getRandomNumber();
        Observable<Integer> follows = getRandomNumber();
        Observable<Integer> shared = getRandomNumber();
        Observable<Integer> comment = getRandomNumber();
        return Observable.zip(likes,follows,shared,comment,(a,b,c,d)->{
            return new EntityStat(a,b,c,d);
        });

    }

    public Observable<UserStat> getUserStat(String id){
        Observable<Boolean> likes = getRandomBoolean();
        Observable<Boolean> follows = getRandomBoolean();
        Observable<Boolean> shared = getRandomBoolean();

        return Observable.zip(likes,follows,shared,(a,b,c)->{
            return new UserStat(a,b,c);
        });
    }

    public Observable<Tags> getTags(String id){
            return Observable.just(new Tags(id)).subscribeOn(Schedulers.io()) ;
    }

    public Observable<Comments> getComments(String id){
        return Observable.just(new Comments(id)).subscribeOn(Schedulers.io()) ;
    }

    public Observable<User> getUser(String id){
        return Observable.just(new User(id,"name"+id)).subscribeOn(Schedulers.io());
    }

    public Observable<String> getPoster(String id){
        return Observable.just("name"+id).subscribeOn(Schedulers.io());
    }

    public void printListSync(){
        getListSync().toBlocking().forEach(a->{
            System.out.println(a);
        });
    }
    public void printListAsync(){
        getListAsync().toBlocking().forEach(a->{
            System.out.println(a);
        });
    }

    public static void main(String[] args) {

        AsyncHelper asyncHelper = new AsyncHelper();
     //   System.out.println(new Random(100).nextInt());
        asyncHelper.zipOperatorEvaluator();


    }

    private void start() {
        entities.add(entity1);entities.add(entity2);entities.add(entity3);
        entities.add(entity4);entities.add(entity5);entities.add(entity6);
        long time = new Date().getTime();
        getObservableListOfEntity(entities);
        long timer = new Date().getTime()-time;
        System.out.println(timer);



    }

    private void getObservableListOfEntity(List<Entity> entities) {

             Observable<Entity> entityObservable = getEntityObservable().flatMap(entity->{

                 Observable<UserStat> userStatObservable = getUserStat(entity.getId());
                Observable<EntityStat> entityStatObservable = getEntityStat(entity.getId());
                Observable<Tags> tagsObservable = getTags(entity.getId());
                Observable<Comments> commentsObservable = getComments(entity.getId());
                Observable<User> userObservable = getUser(entity.getOwnerId());
                Observable<String> stringObservable = getPoster(entity.getPicId());
                 return Observable.zip(userStatObservable,entityStatObservable,tagsObservable,commentsObservable,userObservable,stringObservable,
                        (a,b,c,d,e,f)->{
                            entity.setUserStat(a);
                            entity.setEntityStat(b);
                            entity.setTags(c);
                            entity.setComment(d);
                            entity.setOwner(e);
                            entity.setPicId(f);
                            return new Entity(entity);

                        });

            }).subscribeOn(Schedulers.io());


        List<Entity> entityList = entityObservable.toList().toBlocking().single();

        System.out.println(entityList);

    }


    private Observable<Entity> getEntityObservable(){
        return Observable.from(entities).flatMap(entity -> Observable.create((Subscriber<? super Entity> a) -> {
            // simulate latency

            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            a.onNext(entity);
            a.onCompleted();
        }).subscribeOn(Schedulers.io()));

    }

    public Observable<Integer> getRandomNumber(){
        Random random = new Random(100);
        return Observable.just(random.nextInt()).subscribeOn(Schedulers.io());
    }

    public Observable<Boolean> getRandomBoolean(){
        Random random = new Random();
        return Observable.just(random.nextBoolean()).subscribeOn(Schedulers.io());
    }

    public void zipOperatorEvaluator(){
        System.out.println("start me");
        Observable<Integer> first = getDataSync(1);
        Observable<Integer> second = getDataSync(2);
        Observable<Integer> third = getDataSync(3);
        Observable<Integer> forth = getDataSync(4);
        System.out.println("end me");

          Observable.zip(first,second,third,(a,b,c)->{
              System.out.printf("inside zip");
            System.out.println(a);
             System.out.println(b);
             System.out.println(c);
             //System.out.println(d);
            return null;
        });

    }
}
