Problem Background

Company Lcme is particularly interested in improving the volume and quality of traffic to the

public facing web sites from search engines. Many of these search engines are quite

sophisticated, using advanced algorithms and parallel searching techniques to provide fast,

accurate responses.This problem is however, somewhat simpler.

A group of web pages has been classified by associating a list of keywords, given in decreasing

order of relevance, with each page (i.e., the order of keywords is from the most specific keyword

to the least specific). For example, on the TopGear website a page on reviews of Ford cars may

have the keywords: Ford, Car, Review in that order; the most relevant keyword is Ford.

Queries also include a list of keywords, again from most to least relevant. For example, in a

query consisting of the keyword Ford followed by the keyword Car, Ford is more important than

Car.

In this problem you are to determine the top five (or fewer) pages that match each of an

arbitrary number of queries.

To determine the strength of the relationship between a query and a web page, assume the

keywords for each page and each query are assigned integer weights, in descending

order, starting with N, where N is the maximum number of keywords allowed for a web page and

query.

The strength of the relationship is the sum of the products of the weights associated with

each keyword that appears both in the webpage list and the query list.

For example, assume the following web pages and keyword lists:

Page 1: Ford, Car, Review

Page 2:Toyota, Car

Page 3: Car, Ford

For N equal 8, a query with keywords Ford and Car in that order yields the following strength

ratings.

Page 1: (8x8 + 7x7) = 113

Page 2: (7x7) = 49

Page 3: (8x7)(7x8) = 112.

Similarly, a query with keywords Ford and Review yields the following strength ratings.

Page 1: (8x8 + 7x6) = 106

Page 2: = 0

Page 3: (8x7) = 56

Input

Input data consist of one line for each web page and query.A line consists of a code letter

followed by a list of keywords. Code letters P and Q denote a page and a query. Code letters

and keywords are separated by at least one space. Ps and Qs may occur in any order.

Pages are added sequentially starting with page one. The case of characters in the keywords is

not significant. Each query also has of a list of between one and 8 keywords. Again, case being

insignificant for keywords. Number the queries sequentially starting with one.