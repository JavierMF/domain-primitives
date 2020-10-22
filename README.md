[![CodeFactor](https://www.codefactor.io/repository/github/javiermf/domain-primitives/badge)](https://www.codefactor.io/repository/github/javiermf/domain-primitives)

# domain-primitives
A [domain primitives](http://software.sawano.se/2017/09/domain-primitives.html) library in Kotlin inspired by the concepts 
introduced in [Secury By Design](https://www.manning.com/books/secure-by-design) book.

> A value object so precise in its definition that it, by its mere existence, manifests its validity is called a domain primitive.

In summary, a domain primitive is a value object with some invariants enforced at the time of creation. Using domain primitives
instead of basic language datatypes (int, string, etc.) helps to build more robust and secure systems.

Although some domain primitives are project/domain specific, I found that some of them can be easily shared between projects. This
repository is a library of domain primitives in Kotlin that aim to represent universal concepts so anyone may use them. It will
always be incomplete so I will be adding new ones when I need it or feel it. Contributions are wellcome.

## List of domain primitives

* [Year](src/main/kotlin/org/javiermf/primitives/datetime/Year.kt)
  * vale between -9000000 and 3000
  
* [Email](src/main/kotlin/org/javiermf/primitives/email/Email.kt)
  * value length between 5 and 254
  * value matches regular expression
  
* [Url](src/main/kotlin/org/javiermf/primitives/url/Url.kt)
  * value length less than 2047 (Edge limit)
  * value matches regular expression
  
* [LangISO639](src/main/kotlin/org/javiermf/primitives/lang/LangISO639.kt)
  * value length between 2 and 8
  * value matches regular expression [a-zA-Z]{2,8}
  * value in list of known lang codes
  
* [Isbn](src/main/kotlin/org/javiermf/primitives/isbn/Isbn.kt)
  * value normalized (only numbers) length is 10 or 13
  * value is valid following ISBN10 or ISBN13 validation rules
  
* [Slug](src/main/kotlin/org/javiermf/primitives/slug/Slug.kt)
  * value length less than 2000
  * value matches regular expression [a-z0-9]+(-[a-z0-9]+)*
  
* [PositiveQuantity](src/main/kotlin/org/javiermf/primitives/quantity/PositiveQuantity.kt)
  * value greater or equal than 0
  
