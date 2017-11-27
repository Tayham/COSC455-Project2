#lang racket

; Introductory exercises/problems for Scheme

(display "Hello world!") (newline)

(+ 3 1)

(define (cube n)
  (* n n))

(define (min-of-two a b )
  (if (< a b) a b))

(define (min-of-three a b c)
  (cond
    ((and (< a b) (< a c) a))
    ((and (< a b) (< c a) c))
    (else b)))

(define (cosc455exam1 n)
  (cond
    ((= n 0) (display "IT WAS EASY!") (newline))
    ((= n 1) (display "HARD!") (newline))
    (else (display "VERY, ") (cosc455exam1 (- n 1)))))

(define mylist (list 1 2 3 4 5 6))

(car mylist)
(cdr mylist)
(car (cdr mylist))
(cadr mylist)
(car (cdr (cdr (cdr mylist))))

(cadddr mylist)

(define (remove-third alist)
  (append (list (car alist)) (list (car (cdr alist))) (cdddr alist)))
  
(define (convert alist)
  (map (lambda (x) (if (= x 1) #t #f)) alist))

(define (true? b) (eq? b #t))

(define (truecount alist)
  (length (filter true? alist)))

(define (can-be-divided? n m)
  (cond
    ((= m 1) #t)
    ((= (remainder n m) 0) #f)
    (else (can-be-divided? n (sub1 m)))))

(define (prime? n) (can-be-divided? n (sub1 n)))