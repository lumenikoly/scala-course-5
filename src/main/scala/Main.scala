import task_1.Animal
import task_1.Cat.{Cat, Lion}
import task_1.Fish.{Fish, Salmon, Shark}
import task_1.Snake.{Cobra, Snake}

object Main extends App {

  //1
  def feedFish[A <: Fish](f: A): Unit = println(s"Fish $f is feeded")

  //2
  implicit class PrettyPrint(int: Int) {
     def prettyPrint(): Unit = println(
        s"""-----
          || $int |
          |-----""".stripMargin)
  }
  5.prettyPrint()

  //3
  trait ZooKeeper[-A]

  def cleanFish(zk: ZooKeeper[Fish]): Unit = println("Fish room cleaned")
  def cleanSnake(zk: ZooKeeper[Snake]): Unit = println("Snake room cleaned")
  def cleanCat(zk: ZooKeeper[Cat]): Unit = println("Cat room cleaned")

  val animalKeeper = new ZooKeeper[Animal] {}
  val catKeeper = new ZooKeeper[Cat] {}
  val fishKeeper = new ZooKeeper[Fish] {}
  val snakeKeeper = new ZooKeeper[Snake] {}
  
  cleanCat(catKeeper)
  cleanCat(animalKeeper)

  cleanSnake(snakeKeeper)
  cleanSnake(animalKeeper)

  cleanFish(animalKeeper)
  cleanFish(fishKeeper)
}


