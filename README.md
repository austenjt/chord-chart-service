# chord-chart-generator

A spring-boot 2.x project, demonstrating JPA, Spring-MVC, Lombok, with Postgres.

## Api
GET `/app/findFirstByTitle` by-name

GET `/app/findAll` by-name

POST `/app/submitChart` with-body

BROWSER `/all` or just `/`

## Development Info

I used a tool called [Insomnia](https://insomnia.rest/) as my SQL client.   I use IntelliJ-IDEA with the [Lombok plugin](https://plugins.jetbrains.com/plugin/6317-lombok-plugin)
installed.
This project is designed for use with [Postgres](https://www.postgresql.org/download/).  See the `application.properties` for more info on what is required.

## Input

```
{
  "title": "Minor Swing",
  "author": "Django Reinhardt",
  "info": {
    "copyright": "1937",
    "bpmeasure": "4",
    "bpminute": "110",
    "key": "Am",
    "status": "Reviewed",
    "genre": "Gypsy Jazz",
    "intro": {
      "line": {
        "bars" : [
          {"chord" : "Bb7"}, {"chord" : "E7"},
          {"chord" : "Am"}, {"chord" : "E7"}
        ]
      }
    }
  },
  "grid": {
    "lines" : [
      {"bars" : [
        {"chord" : "Am"}, {"chord" : "Am"},
        {"chord" : "Dm"}, {"chord" : "Dm"}
      ]},
      {"bars" : [
        {"chord" : "E7"}, {"chord" : "E7"},
        {"chord" : "Am"}, {"chord" : "Am"}
      ]},
      {"bars" : [ 
        {"chord" : "Dm"}, {"chord" : "Dm"},
        {"chord" : "Am"}, {"chord" : "Am"}
      ]},
      {"bars" : [
        {"chord" : "Bb7"}, {"chord" : "E7"},
        {"chord" : "Am"}, {"chord" : "E7"}
      ]}
    ]
  }
}
```

## API Response ( /app/findAll )

Formatted Chart output:

NOTE: bars, seconds, and minutes are all dynamically calculated from bpminute, bpmeasure, and grid size

```
[
    {
        "song_id": 1,
        "author": "Django Reinhardt",
        "title": "Minor Swing",
          "info": {
              "id": 1,
              "seconds": 34,
              "minutes": 0.57,
              "copyright": 1937,
              "bpmeasure": 4,
              "bpminute": 110,
              "bars": 16,
              "key": "Am",
              "status": "Reviewed",
              "genre": "Gypsy Jazz",
              "intro": {
                  "intro_id": 1,
                  "line": {
                      "bars": [
                          {"chord": "E7", "id": 16},
                          {"chord": "Am", "id": 15},
                          {"chord": "E7", "id": 14},
                          {"chord": "Bb7", "id": 13}
                      ],
                      "line_id": 5
                  }
              },
              "length": "0"
          },
        "grid": {
            "grid_id": 1,
            "lines": [
                {
                    "bars": [
                        {"chord": "Dm", "id": 4},
                        {"chord": "Dm", "id": 3},
                        {"chord": "Am", "id": 2},
                        {"chord": "Am", "id": 1}
                    ],
                    "line_id": 1
                },
                {
                    "bars": [
                        {"chord": "Am", "id": 8},
                        {"chord": "Am", "id": 7},
                        {"chord": "E7", "id": 6},
                        {"chord": "E7", "id": 5}
                    ],
                    "line_id": 2
                },
                {
                    "bars": [
                        {"chord": "Am", "id": 12},
                        {"chord": "Am", "id": 11},
                        {"chord": "Dm", "id": 10},
                        {"chord": "Dm", "id": 9}
                    ],
                    "line_id": 3
                },
                {
                    "bars": [
                        {"chord": "E7", "id": 16},
                        {"chord": "Am", "id": 15},
                        {"chord": "E7", "id": 14},
                        {"chord": "Bb7", "id": 13}
                    ],
                    "line_id": 4
                }
            ]
        },
        "created": [2017,10,15,9,19,54,348000000],
        "updated": [2017,10,15,9,19,54,349000000]
    }
]
```
   
   
##  Schema generate

The application.properties is configured to allow Spring data to initialize the database via schema.sql file.   Alternatively, you can disable this and allow JPA to create the tables.


## Goal

Create printable charts like this one:  http://emicad.altervista.org/images/nuages.gif

