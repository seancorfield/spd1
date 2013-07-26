# spd1

Clojure versions of solutions from Coursera's [Introduction to Systematic Program Design Part 1](https://class.coursera.org/programdesign-001/class/index)
course from UBC.

## Usage

In order to more closely follow the structure of the Racket/BSL source files in the course, expectations (using `expect`, the closest Clojure equivalent to `check-expect`) are mixed in with the source code.
Look in `src/spd1/` for a file corresponding to each problem/solution from the course (so far).

I'm going to assume you're using [LightTable](http://lighttable.com) since that's really the easiest way to get up and running with Clojure on any platform.
It also works very with the files as structured here: add the repo root to the workspace in LT, navigate into the `src/` tree to open a file, then `ctl-shift-enter` (or `cmd-shift-enter` on Mac) to evaluate it.
You'll see the pass/fail tests at the bottom.

## Some BSL/Racket and Clojure differences

Clojure code lives in "namespaces" so each file begins with a `ns` declaration - see **Boilerplate** below for some more information on the implications
of this. Beyond that boilerplate, you really don't need to care.

BSL/Racket allows you to refer to symbols and `define` them later on. Clojure requires all symbols to be declared before use. Again, see **Boilerplate** below
for some notes on this. Most notably, you'll need to `declare` each function before the examples are written.

Various BSL/Racket primitives don't exist in Clojure. You'll see declarations and definitions for these in the relevant CLojure files as needed.

The `expect` function, used to write examples in the Clojure code, has the *expected value* first, then the *actual value* - the example expression.
This is the opposite way round compared to `check-expect` in BSL/Racket. The `expect` function is actually very powerful, and in a few of the Clojure
files, you'll see examples of alternative ways to write the tests / examples that you might find easier.

In BSL/Racket, we specify the Signature and Purpose as comments. We could do that in Clojure too, but I've chosen to include them as *docstrings*
in the function definitions themselves. Here's an example:

    (defn demolish?
      "BuildingStatus -> Boolean
       produce true if the building is 'old' and should be demolished."
      [bs]
      false) ; stub

The benefit to putting this inside the function definition is that anyone using your code can lookup this information using the `clojure.repl/doc`
function. You can call this on any symbol to learn more about it. Try this and you'll see how useful it can be:

    (clojure.repl/doc map)

In BSL/Racket, we're used to putting our examples (tests) directly into the source code. Although the Clojure examples in this repository also
follow this pattern, it's not at all idiomatic in Clojure. Normally there would be a `test/` tree alongside `src/` and all the tests would be placed
separately in that tree. The big benefit of doing that is that all of the Clojure tooling expects it. Specifically, if you put your `expect` tests
in the `test/` tree, then running `lein expectations` at the command line will run all of the tests. Similarly, in Emacs, tests in a separate file
can easily be run in an attached REPL with a simple keystroke. If you're going to be doing Clojure seriously, that's the way you'll want to go for
tests.

## Boilerplate

There's some boilerplate code in each file that needs a bit of explanation. Clojure code lives in "namespaces" that correspond roughly to the
directory/file structure of the source code. In this repository, the `src/` tree has two children: `spd1/` contains the source code, one file for each
example in the course; and `expectations/` contains a utility to make it easier to run examples inline in each file (so you can ignore it). What
that means is that, for example, `src/spd1/bag.clj` has the namespace `spd1.bag` and thus must begin with:

    (ns spd1.bag
      ...)

In addition, that namespace declaration will contain a `:require` clause that specifies the external dependencies for the file. For the source files
here, that means we always have:

    (ns spd1.sum-n
      (:require [expectations :refer [expect run-tests]]))

This says we're going to use `expect` and `run-tests` from the `expectations` namespace - an external library specified in `project.clj`.

After that we'll have the regular body of the file - Constants, Data Definitions, Functions, etc - just as you'd expect from the BSL examples in the course.
Then at the bottom we have some magic that causes the examples in the file to run and clears out the definitions for the next run:

    (run-tests [*ns*])
    (remove-ns (symbol (str *ns*)))

When you evaluate the whole file in LightTable, you'll see a pass/fail report appear inline next to the `run-tests` function call.
You'll also see a message in the console (the collapsed panel at the bottom of the LightTable workspace), that says how many tests were run,
how many assertions they contained, how long it took, and how many failures and errors there were. Hopefully zero.

Note that you would remove these lines in production code since you would not want each file to automatically run its tests and then remove all the symbols you just defined!
These two lines are here simply to make it easy to work with source + tests mixed together in a single file with LightTable.

In addition, scattered throughout the files, you'll see *forward declarations* of functions. Unlike BSL/Racket, Clojure requires that all symbols are
known in advance of their first use. In BSL/Racket, you can refer to a function but define it further on in the file. In Clojure, you must either
`declare` or `defn` your functions before you use them.

## project.clj

So what's this strange Clojure file at the top of the project tree? It's how you specify attributes of the project and, more importantly, how you
specify any external dependencies you need in your project. The `defproject` construct specifies the Maven-compatible group, artifact and version
(don't worry about that) and a number of attributes, specified by keywords - symbols beginning with `:` - that cover descriptive and functional
aspects of your project. If you get into Clojure development, you'll need to learn about `:dependencies`, `:plugins`, `:profiles` and a few more.

For this project, only `:dependencies` is relevant: we depend on Clojure 1.5.1 and Expectations 1.4.49. When Leiningen - or LightTable - starts a REPL,
it will automatically download those dependencies and cache them (in `.m2/` in your home directory, if you care) and add those JAR files to the Java
classpath before starting the REPL (which is really just a Java program). That makes the namespaces inside those JAR files available to your code,
and that's how the `:require` declaration in each namspace pulls them in and makes functions available to your code.

## License

Copyright © 2013 Sean Corfield

Distributed under the Eclipse Public License, the same as Clojure.
