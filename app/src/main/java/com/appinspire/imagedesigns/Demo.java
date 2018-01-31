package com.appinspire.imagedesigns;


import java.util.ArrayList;
import java.util.List;

/*
 * Created by troy379 on 14.09.16.
 */
public final class Demo {
    private Demo() {
        throw new AssertionError();
    }

    private static final String POSTERS_PATH = "https://s3.ap-northeast-2.amazonaws.com/imagegallery/FingerMehandi";

    public static String[] getPosters() {
        return new String[]{
                POSTERS_PATH + "/design1.jpg",
                POSTERS_PATH + "/design2.jpg",
                POSTERS_PATH + "/design3.jpg",
                POSTERS_PATH + "/design4.jpg",
                POSTERS_PATH + "/design5.jpg",
                POSTERS_PATH + "/design6.jpg",
                POSTERS_PATH + "/design7.jpg",
                POSTERS_PATH + "/design8.jpg",
                POSTERS_PATH + "/design9.jpg",
                POSTERS_PATH + "/design10.jpg",
                POSTERS_PATH + "/design11.jpg",
                POSTERS_PATH + "/design12.jpg",
                POSTERS_PATH + "/design13.jpg",
                POSTERS_PATH + "/design14.jpg",
                POSTERS_PATH + "/design15.jpg",
                POSTERS_PATH + "/design16.jpg",
                POSTERS_PATH + "/design17.jpg",
                POSTERS_PATH + "/design18.jpg",
                POSTERS_PATH + "/design19.jpg",
                POSTERS_PATH + "/design20.jpg",
                POSTERS_PATH + "/design21.jpg",
                POSTERS_PATH + "/design22.jpg",
                POSTERS_PATH + "/design23.jpg",
                POSTERS_PATH + "/design24.jpg",
                POSTERS_PATH + "/design25.jpg",
                POSTERS_PATH + "/design26.jpg",
                POSTERS_PATH + "/design27.jpg",
                POSTERS_PATH + "/design28.jpg",
                POSTERS_PATH + "/design29.jpg",
                POSTERS_PATH + "/design30.jpg",
                POSTERS_PATH + "/design31.jpg",
                POSTERS_PATH + "/design32.jpg",
                POSTERS_PATH + "/design33.jpg",
                POSTERS_PATH + "/design34.jpg",
                POSTERS_PATH + "/design35.jpg",
                POSTERS_PATH + "/design36.jpg",
                POSTERS_PATH + "/design37.jpg",
                POSTERS_PATH + "/design38.jpg",
                POSTERS_PATH + "/design39.jpg"
        };

    }

    public static String[] getDescriptions() {
        return new String[]{
                "Vincent Vega is a hitman and associate of Marsellus Wallace. He had a brother named Vic Vega who was shot and killed by an undercover cop while on a job. He worked in Amsterdam for over three years and recently returned to Los Angeles, where he has been partnered with Jules Winnfield.",
                "Jules Winnfield - initially he is a Hitman working alongside Vincent Vega but after revelation, or as he refers to it \"a moment of clarity\" he decides to leave to \"Walk the Earth.\" During the film he is stated to be from Inglewood, California",
                "Korben Dallas. A post-America taxi driver in New York City with a grand military background simply lives his life day to day, that is, before he meets Leeloo. Leeloo captures his heart soon after crashing into his taxi cab one day after escaping from a government-run laboratory. Korben soon finds himself running from the authorities in order to protect Leeloo, as well as becoming the center of a desperate ploy to save the world from an unknown evil.",
                "Dominic \"Dom\" Toretto is the brother of Mia Toretto, uncle to Jack and husband to Letty Ortiz. The protagonist in The Fast and the Furious franchise, Dominic is an elite street racer and auto mechanic.",
                "Martin Seamus \"Marty\" McFly Sr. - he is the world's second time traveler, the first to travel backwards in time and the first human to travel though time. He was also a high school student at Hill Valley High School in 1985. He is best friends with Dr. Emmett Brown, who unveiled his first working invention to him.",
                "The Driver - real name unknown - is a quiet man who has made a career out of stealing fast cars and using them as getaway vehicles in big-time robberies all over Los Angeles. Hot on the Driver's trail is the Detective (Bruce Dern), a conceited (and similarly nameless) cop who refers to the Driver as \"Cowboy\".",
                "Frank Martin (Transporter) - he initially serves as a reluctant hero. He is portrayed as a former Special Forces operative who was a team leader of a search and destroy unit. His military background includes operations \"in and out of\" Lebanon, Syria and Sudan. He retires from this after becoming fatigued and disenchanted with his superior officers.",
                "Maximillian \"Max\" Rockatansky started his apocalyptic adventure as a Main Force Patrol officer who fought for peace on the decaying roads of Australian civilization. Max served as the last line of defense against the reckless marauders terrorizing the roadways, driving a V8 Interceptor.",
                "Daniel Morales - the fastest delivery man for the local pizza parlor Pizza Joe in Marseille, France. On the last day of work, he sets a new speed record, then leaves the job to pursue a new career as a taxi driver with the blessings of his boss and co-workers. Daniel's vehicle is a white 1997 Peugeot 406..."
        };
    }

}
