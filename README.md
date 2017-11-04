[![Codacy Badge](https://api.codacy.com/project/badge/Grade/7e7b4472a8d342e3839dd70cbc600838)](https://www.codacy.com/app/conrado-m/workbook?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=crgz/workbook&amp;utm_campaign=Badge_Grade)
[![Build Status](https://travis-ci.org/crgz/workbook.svg?branch=master)](https://travis-ci.org/crgz/workbook)
[![Coverage Status](https://coveralls.io/repos/github/crgz/workbook/badge.svg?branch=master)](https://coveralls.io/github/crgz/workbook?branch=master)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg?style=flat-square)](http://makeapullrequest.com)

<img src="./site/icons/Libreoffice_icon_mix.png?raw=true" width="20%" align="right" style="border:20px solid white">


# Excel Workbook Handler

## 💡 Synopsis
The WorkbookData class uses the Apache POI project to load data from an Excel spreadsheet and transform it into a Collection. A CustomMapper class might be added for a cleaner translation between the data and the logic. See an example in the section Usage below.

## 💾 Installation

To install the Java client library to your local Maven repository, simply execute:

```shell
git clone --recursive git@github.com:crgz/workbook.git
cd workbook
mvn install
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
    <dependency>
      <groupId>com.github.crgz</groupId>
      <artifactId>workbook</artifactId>
      <version>1.0</version>
      <scope>test</scope>
    </dependency>
```

### Gradle users

```groovy
compile 'com.github.crgz:workbook:1.0'
```

### Others

At first generate the JAR by executing:

```
git clone --recursive git@github.com:crgz/workbook.git
cd workbook
mvn package
```

Then manually install the following JARs:

* target//workbook-1.0.jar

## ▶️ Usage

```Java
public class AggregatorTest
{
...

	@Before
	public void setUp() throws IOException, WorkbookDataException
	{
		this.data = new WorkbookData.Builder("src/test/resources/sample.xls").sheet(0).build().collection();
	}

	@Test
	public void testAggregator() throws IOException, WorkbookDataException
	{
		this.data.stream().map(CustomMapper::map).forEach(x ->
		{
			final Foo event = x.getKey();
			this.resource.accept(event);					
			final Baz expected = x.getValue();
			final Baz actual = this.resource.get();
			assertEquals(expected, actual);
		});
	}
}
```
Sample CustomMapper:

```Java

public class EventStatisticsMapper
{
	public static SimpleEntry<Event, Statistics> map(Object[] x)
	{
		final long time = ((Double) x[0]).longValue();
		final int value = ((Double) x[1]).intValue();
		final long sum = ((Double) x[3]).longValue();
		final long count = ((Double) x[4]).longValue();
		double avg = (double) sum / count;
		final long max = ((Double) x[5]).longValue();
		final long min = ((Double) x[6]).longValue();
		return new SimpleEntry<Foo, Baz>(new Foo(time * 1000, value), new Baz(sum, count, max, min, avg));
	}
}
```

## 🎁 Contributing

1. Fork it!
2. Create your feature branch: `git checkout -b my-new-feature`
3. Commit your changes: `git commit -am 'Add some feature'`
4. Push to the branch: `git push origin my-new-feature`
5. Submit a pull request :D

## 🎓 License
This experiment is released under the [Apache-2.0](https://opensource.org/licenses/Apache-2.0) license.
