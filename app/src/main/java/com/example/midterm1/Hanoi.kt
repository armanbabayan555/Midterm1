package com.example.midterm1

import java.util.Scanner
import java.util.Stack
import kotlin.collections.ArrayList


fun main() {
    println("Input a number: ")
    var reader = Scanner(System.`in`)
    var num = reader.nextInt();
    var stacks = ArrayList<Stack<Int>>()
    var numberOfMoves = 0;


    stacks.add(Stack())
    stacks.add(Stack())
    stacks.add(Stack())

    for (i in num downTo 1) {
        stacks[0].push(i)
    }

    // odd
    if (num % 2 != 0) {
        while (stacks[2].size < num) {
            moveDisk(stacks, 0, 2)
            numberOfMoves++
            if (stacks[2].size == num)
                break
            moveDisk(stacks, 0, 1)
            numberOfMoves++
            if (stacks[2].size == num)
                break
            moveDisk(stacks, 1, 2)
            numberOfMoves++
        }
    }

    // even
    else {
        while (stacks[2].size < num) {
            moveDisk(stacks, 0, 1)
            numberOfMoves++
            if (stacks[2].size == num)
                break
            moveDisk(stacks, 0, 2)
            numberOfMoves++
            if (stacks[2].size == num)
                break
            moveDisk(stacks, 1, 2)
            numberOfMoves++
        }
    }

    println("Done in " + numberOfMoves + " moves!")
}

private fun moveDisk(stacks: ArrayList<Stack<Int>>, from: Int, to: Int) {
    var disk = stacks[from].pop()
    stacks[to].push(disk)
    println("Move the disk " + disk + " from stack " + (from + 1) + " to stack " + (to + 1))
}