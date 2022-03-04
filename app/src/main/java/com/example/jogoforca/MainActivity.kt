/**
 * IFPB - TSI
 * Padroes Dispositivos Móveis
 * Professora Valéria Maria Bezerra Cavalcanti
 * Aluno Renato Ribeiro da Silva
 *
 * Março 2022
 */

package com.example.jogoforca

class Desafio (val palavra: String, val dica: String)

fun main() {
    // Adicionar Palavra + Dica
    val dic = Desafio("COMPUTADOR", "É constituído de hardware e software.")

    // Tratamento da palavra informada
    var tampal = dic.palavra.length
    var palspl = dic.palavra.split("").slice(1..tampal)

    // Tratar quantas letras são distintas na palavra
    var dist = linkedSetOf<String>()
    var i = 0
    for(let in palspl){
        if (let in palspl[i]){
            dist.add(let)
            i++
        }
    }

    // Informação iniciais e regras do jogo
    println("          BEM VINDO AO JOGO DA FORCA")
    println("=================================================")
    print("Dica 01: ")
    println("${dic.dica}")
    print("Dica 02: ")
    //println("A palavra contem ${dic.palavra.length} letras")
    println("A palavra contem ${tampal} letras.")
    print("Dica 03: ")
    println("A palavra contem ${dist.size} letras distintas.")
    print("Dica 04: ")
    println("Você pode errar até ${dist.size} vezes.")
    println("=================================================")

    // Esconder a palavra do jogo
    var novpal = arrayListOf<String>()
    for(let in palspl){
        novpal.add("*")
    }
    println("Status da palavra: ${novpal}")

    // Controles de acesso, erros e acertos no jogo
    var tent: Int = 0
    var tace: Int = 0
    var terr: Int = 0
    var letra: String?
    var acerto = linkedSetOf<String>()
    var erro = linkedSetOf<String>()
    var index = 0
    println()

    while (tent < tampal){
        // Input da letra
        println("Digite uma letra:")
        letra = (readLine().toString()).uppercase()

        // Testar a frequencia que a letra aparece na palavra
        var frequency = 0
        for (i in 0.. palspl.size - 1){
            if (letra == palspl[i]) {
                ++frequency
                novpal[i] = letra
            }
        }

        // Controle de acertos, erros e tentativas
        if (letra in palspl){
            println("Parabéns!, a palavra contém a letra < ${letra} >.")
            acerto.add(letra)
            tent++
            tace = tace + frequency
        }
        else{
            println("Infelizmente a letra < ${letra} > não existe na palavra.")
            erro.add(letra)
            tent++
            terr++
        }

        println("=================================================")
        println("Total Acertos: ${tace}")
        println("Total Erros: ${terr}")
        println("Status da palavra: ${novpal}")
        println("=================================================")
    }

    // Fim do Jogo
    println("                FIM do jogo")
    if (terr == tampal){
        println("           GAME OVER, você perdeu!")
    }
    else
        println("            PARABÉNS, você ganhou.")

}
