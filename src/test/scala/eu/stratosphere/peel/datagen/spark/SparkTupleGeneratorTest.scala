package eu.stratosphere.peel.datagen.spark

import eu.stratosphere.peel.datagen.util.Distributions._
import org.junit.Test
import org.scalatest.junit.AssertionsForJUnit

class SparkTupleGeneratorTest extends AssertionsForJUnit {

  @Test def integrationTest() {
    val output = "data/tupleGeneratorOutput"
    val master = "local[3]"
    // N should have a common demnominator with K and dop
    val dop = 3
    val N = 10000
    val pay = 5
    val keyDist = Pareto(1)
    val aggDist = Uniform(20)

//

    SparkTupleGenerator.main(Array(master, dop, N, keyDist, pay, aggDist, output).map(_.toString))

  }

}
