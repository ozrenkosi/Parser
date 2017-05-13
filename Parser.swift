//
//  Parser.swift
//  Parser
//
//  Created by Ozren Kosi on 04.05.2017..
//  Copyright © 2017. Ozren Kosi. All rights reserved.
//

import Foundation

var inputString = [String]()
var parserOK = Bool()

func dataInput() {
    let temporaryInput = readLine()!
    inputString = temporaryInput.characters.map { String($0) }
}

func parseString_S() {
    parserOK = false
    print("S", terminator:"")
    
    if (inputString.isEmpty) {
        parserOK = false
        return
    }
    else if (inputString[0] == "b") {
        inputString.remove(at: 0)
        parseString_B()
        if (parserOK) {
            parseString_A()
        }
        return
    }
    
    if (inputString.isEmpty) {
        parserOK = false
    }
    else if (inputString[0] == "a") {
        inputString.remove(at: 0)
        parseString_A()
        if (parserOK) {
            parseString_B()
            
        }
    }
}

func parseString_A() {
    parserOK = false
    print("A", terminator:"")
    
    if (inputString.isEmpty) {
        parserOK = false
        return
    }
    else if (inputString[0] == "b") {
        inputString.remove(at: 0)
        parseString_C()
        return
    }
    
    if (inputString.isEmpty) {
        parserOK = false
    }
    else if (inputString[0] == "a") {
        inputString.remove(at: 0)
        parserOK = true
    }
}

func parseString_B() {
    parserOK = false
    print("B", terminator:"")
    
    if (inputString.isEmpty) {
        parserOK = true
    }
    else {
        parserOK = false
        if (inputString[0] == "c") {
            inputString.remove(at: 0)
            if (!inputString.isEmpty && inputString[0] == "c") {
                inputString.remove(at: 0)
                parseString_S()
                if (parserOK && !inputString.isEmpty && inputString[0] == "b") {
                    inputString.remove(at: 0)
                    if (!inputString.isEmpty && inputString[0] == "c") {
                        inputString.remove(at: 0)
                        parserOK = true
                    }
                    else {
                        parserOK = false
                    }
                }
                else {
                    parserOK = false
                }
            }
            else {
                parserOK = false
            }
        }
        else {
            parserOK = true
        }
    }
}

func parseString_C() {
    parserOK = false
    print("C", terminator:"")
    
    parseString_A()
    if (parserOK) {
        parseString_A()
    }
}

func checkDefinition() {
    print()
    
    if (parserOK && inputString.isEmpty) {
        print("DA")
    }
    else {
        print("NE")
    }
}

dataInput()

parseString_S()

checkDefinition()
