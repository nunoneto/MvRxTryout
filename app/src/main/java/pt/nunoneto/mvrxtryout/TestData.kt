package pt.nunoneto.mvrxtryout

import io.reactivex.Single
import java.util.concurrent.TimeUnit

fun getExampleEntities() =
    Single.just(
        listOf(
            ExampleEntity(
                1,
                "Batman",
                "Bill Finger, Bob Kane, Bruce Timm",
                "https://imgix.ranker.com/user_node_img/28/549942/original/batman-photo-u182?w=120&h=120&q=60&fm=pjpg&fit=crop&crop=faces"
            ),
            ExampleEntity(
                2,
                "Spider-Man",
                "Stan Lee, Steve Ditko",
                "https://imgix.ranker.com/user_node_img/104/2075534/original/spider-man-comic-book-characters-photo-u5?w=120&h=120&q=60&fm=pjpg&fit=crop&crop=faces"
            ),
            ExampleEntity(
                3,
                "Wolverine",
                "Len Wein, Roy Thomas, John Romita",
                "https://imgix.ranker.com/user_node_img/130/2596629/original/wolverine-comic-strips-photo-u2?w=120&h=120&q=60&fm=pjpg&fit=crop&crop=faces"
            ),
            ExampleEntity(
                4,
                "Iron Man",
                "Jack Kirby, Stan Lee, Don Heck",
                "https://imgix.ranker.com/user_node_img/62/1237308/original/iron-man-comic-book-characters-photo-u2?w=120&h=120&q=60&fm=pjpg&fit=crop&crop=faces"
            ),
            ExampleEntity(
                5,
                "Captain America",
                "Joe Simon, Jack Kirby",
                "https://imgix.ranker.com/user_node_img/34/669163/original/captain-america-comic-book-characters-photo-u6?w=120&h=120&q=60&fm=pjpg&fit=crop&crop=faces"
            ),
            ExampleEntity(
                6,
                "Superman",
                "Joe Shuster, Jerry Siegel",
                "https://imgix.ranker.com/user_node_img/107/2124152/original/superman-comic-book-characters-photo-u28?w=280&h=280&fit=crop&crop=faces&q=50&fm=pjpg"
            ),
            ExampleEntity(
                7,
                "Hulk",
                "Jack Kirby, Stan Lee",
                "https://imgix.ranker.com/user_node_img/60/1188861/original/hulk-comic-book-characters-photo-u4?w=120&h=120&q=60&fm=pjpg&fit=crop&crop=faces"
            ),
            ExampleEntity(
                8,
                "Thor",
                "Jack Kirby, Stan Lee, Larry Lieber",
                "https://imgix.ranker.com/user_node_img/112/2239723/original/thor-comic-book-characters-photo-u5?w=87&h=87&fit=crop&crop=faces&q=60&fm=pjpg"
            )
        )
    ).delay(3000, TimeUnit.MILLISECONDS)