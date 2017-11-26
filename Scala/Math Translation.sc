val chinese: List[String] = List("ling", "yi", "er", "san", "si", "wu", "liu", "qi", "ba", "jiu", "shi")
val english: List[String] = List("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten")

def go(list : List[String]) : Unit = {
  val num : List[Int] = construct(list)
  println("Translation: " + num.mkString(" "))
  println("Addition: " + num.mkString(" + ") + " = " + add(num))
  println("Multiplication: " + num.mkString(" * ") + " = " + multi(num))
}

def construct(list : List[String]) : List[Int] = {
  list match {
    case Nil => Nil
    case head::tail => chinese.contains(head) match { // if list contains Chinese
        case true => chinese.indexOf(head)::construct(tail) // convert to Int
        case false => english.contains(head) match { // if list contains English
            case true => english.indexOf(head)::construct(tail)// convert to Int
            case false => Nil // ignore
          }
      }
  }
}

def add(list : List[Int]) : Int = list.sum

def multi(list : List[Int]) : Int = list.product

go(List("yi", "nine", "six", "ba", "josh"))