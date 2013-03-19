enterpriceless
==============

Sample WebNoir json-project from 15.3. Clojure Intro.

## Usage

```bash
lein deps
lein run
```

## Packaging

```bash
lein do clean, uberjar
```

## Using

* try httpie (https://github.com/jkbr/httpie)

### Add Pertti

```
> http post http://localhost:8080/api/users name=pertti address:='{"street": "kaatokuja", "number": 1, "zip": 33101}'

HTTP/1.1 200 OK
Content-Length: 82
Content-Type: application/json; charset=utf-8
Date: Mon, 18 Mar 2013 19:33:32 GMT
Server: Jetty(7.6.1.v20120215)

{
    "address": {
        "number": 1,
        "street": "kaatokuja",
        "zip": 33101
    },
    "id": "1",
    "name": "pertti"
}
```

### Add Liisa

```bash
> http post http://localhost:8080/api/users name=liisa age=26 address:='{"street": "latokuja", "number": 16, "zip": 33110}'

HTTP/1.1 200 OK
Content-Length: 92
Content-Type: application/json; charset=utf-8
Date: Mon, 18 Mar 2013 19:34:20 GMT
Server: Jetty(7.6.1.v20120215)

{
    "address": {
        "number": 16,
        "street": "latokuja",
        "zip": 33110
    },
    "age": "26",
    "id": "2",
    "name": "liisa"
}
```

### List users

```bash
> http http://localhost:8080/api/users

HTTP/1.1 200 OK
Content-Length: 185
Content-Type: application/json; charset=utf-8
Date: Mon, 18 Mar 2013 19:34:28 GMT
Server: Jetty(7.6.1.v20120215)

{
    "1": {
        "address": {
            "number": 1,
            "street": "kaatokuja",
            "zip": 33101
        },
        "id": "1",
        "name": "pertti"
    },
    "2": {
        "address": {
            "number": 16,
            "street": "latokuja",
            "zip": 33110
        },
        "age": "26",
        "id": "2",
        "name": "liisa"
    }
}
```

### Remove Pertti

```bash
> http delete http://localhost:8080/api/users/1

HTTP/1.1 200 OK
Content-Length: 98
Content-Type: application/json; charset=utf-8
Date: Mon, 18 Mar 2013 19:34:36 GMT
Server: Jetty(7.6.1.v20120215)

{
    "2": {
        "address": {
            "number": 16,
            "street": "latokuja",
            "zip": 33110
        },
        "age": "26",
        "id": "2",
        "name": "liisa"
    }
}
```

## License

Copyright (c) 2013 Tommi Reiman

See LICENSE
