package eu.stratosphere.peel.datagen.spark

import java.io.File

import org.apache.commons.io.FileUtils
import org.junit.Test
import org.scalatest.junit.AssertionsForJUnit

class SparkSparkClusterGeneratorTest extends AssertionsForJUnit {

  @Test def integrationTest() {
    val numTasks = 1
    val tuplesPerTask = 4793490 * 2
    // master with given numTasks
    val master = s"local[$numTasks]"
    // input and output path
    val input = getClass.getResource("/clusterCenters.csv")
    val output = s"${System.getProperty("java.io.tmpdir")}/data/clusterGeneratorOutput"

    // delete output file if exists
    FileUtils.deleteDirectory(new File(output))

    val gen = new SparkClusterGenerator(master, numTasks, tuplesPerTask, input.toString, output)
    gen.run()

  }

}
