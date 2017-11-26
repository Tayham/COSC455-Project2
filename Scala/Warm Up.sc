//Prime Numbers (1 points). Create a function, named prime, that takes an integer and returns a
//Boolean indicating whether the integer parameter is a prime number. A prime number is an
//integer greater than 1 that has no positive divisors other than 1 and itself.
def prime(prime: Int): Boolean = {
  prime < 2 match {
    case true => false
    case false => !2.until(prime - 1).exists(prime % _ == 0)
  }
}
prime(-1)
prime(0)
prime(1)
prime(2)
prime(4)
prime(5)
prime(12)
prime(13)


//Twin Primes (1 points). Create a function, named twinprimes, that takes 2 integer parameters
//and returns a Boolean indicating whether the parameters are twin primes. A twin prime is a
//prime number that differs from another prime number by two, for example the twin prime pair (41, 43).
//For example, twinprimes (41, 43) should return true and twinprimes (43, 47)
//would return false.
def twinprimes(prime1: Int, prime2: Int): Boolean = {
  prime1 - prime2 match {
    case 2 => prime(prime1) && prime(prime2)
    case -2 => prime(prime1) && prime(prime2)
    case _ => false
  }
}
twinprimes(41, 43)
twinprimes(43, 41)
twinprimes(43, 47)
twinprimes(47, 43)
twinprimes(6, 8)
twinprimes(8, 6)

//Twin Primes List (1 points). Create a function, named twinprimeslist, that takes an integer, n,
//parameter and returns an integer list of all the twin primes starting up to n. For example,
//twinprimeslist (50) should return [3, 5, 7, 11, 13, 17, 19, 29, 31, 41, 43] (no duplicates).

def twinprimeslist(n: Int): List[Int] = {
  List.range(2, n + 1) filter { x => twinprimes(x, x + 2) || twinprimes(x, x - 2) }
}

twinprimeslist(50)

//Goldbach’s Conjecture (2 points). Create a function, named goldbach, that takes an integer
//and prints the solution satisfying the Goldbach Conjecture. The Goldbach Conjecture states
//that every positive even number greater than 2 is the sum of two prime numbers. For example,
//28 = 5 + 23. Your function is to find the two prime numbers that sum up to a given even
//integer and print the composition. For example goldbach(28) would print  5 + 23 = 28. You
//should provide error checking to make sure the integer parameter is even and greater than 2.

def goldbach(n: Int): Unit = {
  (n % 2 == 1, n <= 2) match {
    case (true, false) => println("Odd number")
    case (false, true) => println("Number not greater than 2")
    case (false, false) => goldbachHelper(n, List.range(2, n) filter { x => prime(x) })
  }
}

def goldbachHelper(n: Int, pList: List[Int]): Unit = {
  pList.contains(n - pList.head) match {
    case true => println(pList.head + " + " + (n - pList.head) + " = " + n)
    case false => goldbachHelper(n, pList.tail)
  }
}

goldbach(2)
goldbach(3)
goldbach(4)
goldbach(12)
goldbach(28)