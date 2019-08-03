// import required spark classes
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

case class Person(id: Long, name: String, cityId: Long)
case class City(id: Long, name: String)

// define main method (Spark entry point)
object HelloWorld {
  def main(args: Array[String]) {
 
    // initialise spark context
    val conf = new SparkConf().setAppName(HelloWorld.getClass.getName)
    val spark: SparkSession = SparkSession.builder.config(conf).getOrCreate()
    import spark.implicits._
    val family = rddToDatasetHolder(spark.sparkContext.parallelize(Seq(
      Person(0, "Agata", 0),
      Person(1, "Iweta", 0),
      Person(2, "Patryk", 2),
      Person(3, "Maksym", 0)))).toDS()
    val cities = Seq(
      City(0, "Warsaw"),
      City(1, "Washington"),
      City(2, "Sopot")).toDS()

    val joined = family.joinWith(cities, family("cityId") === cities("id"))
    println(joined.schema)
    println(joined.first())

    // terminate spark context
    spark.stop()
    
  }
}

