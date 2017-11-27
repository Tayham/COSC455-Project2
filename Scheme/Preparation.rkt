#lang racket
(define first (lambda (x) (car x)))
(define second (lambda (x) (cadr x)))
(define third (lambda (x) (caddr x)))
(define forth (lambda (x) (cadddr x)))
(define fifth (lambda (x) (car(cddddr x))))
(define family '(josh sara erin sandy jon))
(first family)
(second family)
(third family)
(fourth family)
(fifth family)
(define tfList '(#t #t #f #t #f #f #t))
(define sqList '(1 2 3 4 5 6 7 8 9 10))
(define hunList '(1225 55 982 2 4 98 18 0 -2 101 100 99))

;truecount
(define (truecount alist)
  (count identity alist))

(truecount tfList)

;squarelist
(define (squarelist alist)
  (map (lambda (x) (* x x)) alist))

(squarelist sqList)

;hundreds (not sure if you wanted us to count 100)
(define (hundreds? alist)
  (filter (lambda (x) (> x 100)) alist))

(hundreds? hunList)

;collatz 
(define (collatz n)
  (display n)(newline)
  (cond ((eq? n 1) (display "Done") (newline))
        ((even? n) (collatz (/ n 2)))
        ((odd? n) (collatz (+ (* n 3) 1)))))

(collatz 25)