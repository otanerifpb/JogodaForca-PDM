package com.example.jogoforca


class Desafio() {
    var palavra: String = ""
    var dica: String = ""
    constructor(palavra: String, dica: String) : this() {
        this.palavra = palavra
        this.dica = dica
    }

    fun jogar(palavra: String, dica: String) {
        // Tratamento da palavra informada
        var tampal = palavra.length
        var palspl = palavra.split("").slice(1..tampal)

        var dist = quantasLetrasDisntintas(palspl)
        regrasDoJogo(tampal, dist, dica)
        var novpal = esconderPalavra(palspl)
        controleDoJogo(tampal, palspl, novpal)

    }

    fun quantasLetrasDisntintas(palspl: List<String>): LinkedHashSet<String> {
        // Tratar quantas letras são distintas na palavra
        var dist = linkedSetOf<String>()
        var i = 0
        for (let in palspl) {
            if (let in palspl[i]) {
                dist.add(let.toString())
                i++
            }
        }
        return dist
    }

    fun regrasDoJogo(tampal: Int, dist: LinkedHashSet<String>,  dica: String){
        // Informação iniciais e regras do jogo
        println("          BEM VINDO AO JOGO DA FORCA")
        println("=================================================")
        print("Dica 01: ")
        println("${dica}")
        print("Dica 02: ")
        //println("A palavra contem ${dic.palavra.length} letras")
        println("A palavra contem ${tampal} letras")
        print("Dica 03: ")
        println("A palavra contem ${dist.size} letras são distintas")
        println("Você tem ${dist.size} tentativas")
        println("=================================================")
    }
    fun esconderPalavra(palspl: List<String>): ArrayList<String> {
        // Esconder a palavra do jogo
        var novpalavra = arrayListOf<String>()
        for(let in palspl){
            novpalavra.add("*")
        }
        return novpalavra
    }

    fun controleDoJogo(tampal: Int, palspl: List<String>, novpal: ArrayList<String>) {
        // Controles de acesso, erros e acertos no jogo
        var tent: Int = 0
        var tace: Int = 0
        var terr: Int = 0
        var letra: String?
        var acerto = linkedSetOf<String>()
        var erro = linkedSetOf<String>()
        var index = 0
        var frequency = 0
        println()

        while (tent < tampal) {
            println("Digite uma letra:")
            letra = (readLine().toString()).uppercase()
            var jaDigitou = verificarSeLetraJaDigitada(letra, novpal)
            if(jaDigitou){
                println("Você já Digitou essa letra! < ${letra} >.")
                continue
            }

            for (i in 0..palspl.size - 1) {
                if (letra == palspl[i]) {
                    ++frequency
                    novpal[i] = letra
                }
            }
            if (letra in palspl) {
                println("Parabéns!, a palavra contém a letra < ${letra} >.")
                acerto.add(letra)
                tent++
                tace = frequency
                pontuacao(tace, terr, novpal, frequency)

            } else {
                println("Infelizmente a letra < ${letra} > não existe na palavra.")
                erro.add(letra)
                tent++
                terr++
                pontuacao(tace, terr, novpal, frequency)
            }
        }

        resultado(terr, tampal)
    }
    fun verificarSeLetraJaDigitada(letra: String, novpal: List<String>): Boolean {
        for (i in 0..novpal.size - 1) {
            if (letra.equals(novpal[i])) {
                return true
            }
        }
        return false
    }
    fun pontuacao(tace: Int, terr: Int, novpal: ArrayList<String>, frequency: Int) {
        println("=========================================")
        println("Total Acertos: ${tace}")
        println("Total Erros: ${terr}")
        println("Status da palavra: ${novpal}")
        println("========================================= " + frequency)
    }

    fun resultado(terr: Int, tampal: Int) {
        // Fim do Jogo
        println("FIM do jogo")
        if (terr == tampal){
            println("GAME OVER, você perdeu.")
        }
        else
            println("PARABÉNS, você ganhou.")
    }

}

