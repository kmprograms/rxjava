package pl.kmprograms;


import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import pl.kmprograms.model.Person;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class App1
{
    public static void main( String[] args )
    {
        var people = List.of(
                Person.builder().name("ANDY").age(10).hobbies(List.of("H1", "H2", "H3")).build(),
                Person.builder().name("JOHN").age(20).hobbies(List.of("H4", "H5")).build(),
                Person.builder().name("PAUL").age(30).hobbies(List.of("H6", "H7", "H8")).build(),
                Person.builder().name("TOM").age(40).hobbies(List.of("H9")).build());

        Observable<Person> o1 = Observable.fromIterable(people);

        /*o1
                .filter(p -> p.getAge() >= 40)
                .map(Person::getName)
                .reduce(( n1, n2 ) -> n1.compareTo(n2) > 0 ? n1 : n2)
                .subscribe(System.out::println, System.out::println, () -> System.out.println("DONE"));*/

        /*o1
                .groupBy(Person::getAge)
                .subscribe(e -> e.map(Person::getName).subscribe(ee -> System.out.println(e.getKey() + ": " + ee)));*/

        /*o1
                .filter(p -> p.getAge() < 10)
                .defaultIfEmpty(Person.builder().name("A").age(55).build())
                .subscribe(System.out::println);*/

        /*o1
                .filter(p -> p.getAge() < 10)
                .switchIfEmpty(Observable.error(new IllegalStateException("err1")))
                .subscribe(System.out::println, System.out::println);*/


        /*Observable<String> o2 = Observable.just("ANDY", "JOHN");
        o2.startWith(Observable.just("JIM")).subscribe(System.out::println);*/


        /*try {
            var counter = new CountDownLatch(1);
            var o21 = Observable
                    .zip(Observable.just("A", "B", "C"),
                            Observable.interval(1, TimeUnit.SECONDS).take(3),
                            (oo1, oo2) -> oo1);
            var o22 = Observable
                    .zip(Observable.just("AA", "BB", "CC"),
                            Observable.interval(2, TimeUnit.SECONDS).take(3),
                            (oo1, oo2) -> oo1);

            Observable
                    .merge(o21, o22)
                    .subscribe(System.out::println, System.out::println, counter::countDown);

            counter.await();
        } catch ( Exception e ) {
            e.printStackTrace();
        }*/


        /*try {
            var counter = new CountDownLatch(1);
            var o31 = Observable
                    .zip(Observable.just("W1", "W2", "W3"),
                            Observable.interval(2, TimeUnit.SECONDS).take(3),
                            (oo1, oo2) -> oo1);
            var o32 = Observable.error(new IllegalStateException("illegal state!"));
            Observable
                    .mergeDelayError(o31, o32)
                    .subscribe(data -> System.out.println("DATA: " + data), err -> System.out.println("ERR: " + err), counter::countDown);

            counter.await();
        } catch ( Exception e ) {
            e.printStackTrace();
        }*/



        var p = Person.builder().name("ANDY").age(10).hobbies(List.of("H1", "H2", "H3")).build();
        Single<Person> s1 = Single.just(p);

        // s1.map(Person::getName).subscribe(System.out::println);

        /*s1
                .toObservable()
                .filter(pp -> pp.getAge() < 10)
                .doOnEach(pp -> {
                    if ( pp.getValue() == null ) {
                        System.out.println("Error");
                    }
                }).subscribe(System.out::println);*/




    }
}
