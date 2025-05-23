This folder contains the implementation of our contributions based on JPlag. Note that they are already integrated into the release version of JPlag.
IMPORTANT: JPlag is licensed under GPL-3.0.

How to Use
----------

1. Install Java 21 or newer.
2. Run the Jar file via your CLI: "java -jar jplag-6.0.0-jar-with-dependencies PATH" where PATH is the path to your input directory. Multiple input directories can be specified via "--new" and "--old" (for the latter, programs are not checked amongst each other).
3. Add "-h" to see all options.
4. Specify the language via "-l".
5. Enable subsequence match merging via "--match-merging"
6. For the Java and C++ languages use "--normalize" for token sequence normalization.

Where to Find the Code
----------------------
1. The code is available at https://github.com/jplag/JPlag/tree/v6.0.0 and can be cloned.
2. See the readme file for information on how to build and run the code.