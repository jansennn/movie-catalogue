package com.andreas.movie_catalogue.utils

import com.andreas.movie_catalogue.R
import com.andreas.movie_catalogue.data.MovieEntity

object DataDummyMovie {
    fun getMovies() :ArrayList<MovieEntity> {
        return arrayListOf(
            MovieEntity(
                "1",
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "2h 2m",
                "Action, Science Fiction, Adventure",
                R.drawable.poster_alita
            ),
            MovieEntity(
                "2",
                "Aquaman",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "2h 24m",
                "Action, Adventure, Fantasy",
                R.drawable.poster_aquaman
            ),
            MovieEntity(
                "3",
                "Cold Pursuit",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "1h 59m",
                "Action, Crime, Thriller",
                R.drawable.poster_cold_persuit
            ),
            MovieEntity(
                "4",
                "Creed II",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "2h 10m",
                "Drama",
                R.drawable.poster_creed
            ),
            MovieEntity(
                "5",
                "Fantastic Beasts: The Crimes of Grindelwald",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "2h 14m",
                "Adventure, Fantasy, Drama",
                R.drawable.poster_crimes
            ),
            MovieEntity(
                "6",
                "How to Train Your Dragon: The Hidden World",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "1h 44m",
                "Animation, Family, Adventure",
                R.drawable.poster_how_to_train
            ),
            MovieEntity(
                "7",
                "Mortal Engines",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                "2h 9m",
                "Adventure, Fantasy",
                R.drawable.poster_mortal_engines
            ),
            MovieEntity(
                "8",
                "Overlord",
                "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, in addition to fighting the Nazi troops that patrol the village, they also must fight against something else.",
                "1h 50m",
                "Horror, War, Science Fiction",
                R.drawable.poster_overlord
            ),
            MovieEntity(
                "9",
                "Spider-Man: Into the Spider-Verse",
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                "1h 57m",
                "Action, Adventure, Animation, Science Fiction, Comedy",
                R.drawable.poster_spiderman
            ),
            MovieEntity(
                "10",
                "T-34",
                "In 1944, a courageous group of Russian soldiers managed to escape from German captivity in a half-destroyed legendary T-34 tank. Those were the times of unforgettable bravery, fierce fighting, unbreakable love, and legendary miracles.",
                "2h 19m",
                "War, Action, Drama, History",
                R.drawable.poster_t34
            )
        )
    }
}