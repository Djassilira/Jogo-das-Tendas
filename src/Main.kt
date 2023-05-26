import java.io.File

fun criaLegendaContadoresHorizontal(contadoresHorizontal: Array<Int?>): String {
    var legendaHorizontal = ""
    for (contador in contadoresHorizontal) {
        if (contador == null) {
            legendaHorizontal += "    "
        } else {
            if (contador != contadoresHorizontal[contadoresHorizontal.size - 1]) {
                legendaHorizontal += "$contador   "
            } else {
                legendaHorizontal += "$contador"
            }
        }
    }
    return legendaHorizontal
}

fun leContadoresDoFicheiro(numLines: Int, numColumns: Int, verticais: Boolean): Array<Int?> {
    val ficheiros = File("$numLines" + "x" + "$numColumns" + ".txt").readLines()
    if (verticais) {
        val matriz: Array<Int?> = Array(numColumns, { null })
        val colunas = ficheiros[0].split(",")
        for (posicao in 0..numColumns - 1) {
            if (colunas[posicao].toInt() > 0) {
                matriz[posicao] = colunas[posicao].toInt()
            }
        }
        return matriz
    } else {
        val matriz: Array<Int?> = Array(numLines, { null })
        val linhas = ficheiros[0].split(",")
        for (posicao in 0..numLines - 1) {
            if (linhas[posicao].toInt() > 0) {
                matriz[posicao] = linhas[posicao].toInt()
            }
        }
        return matriz
    }
}

fun leTerrenoDoFicheiro(numLines: Int, numColumns: Int): Array<Array<String?>> {
    val terreno: Array<Array<String?>> = Array(numLines) { arrayOfNulls<String?>(numColumns) }
    val ficheiros = File("$numLines" + "x" + "$numColumns" + ".txt").readLines()
    for (linha in 0..numLines) {
        for (coluna in 0..numColumns) {
            for (posicao in ficheiros) {
                if ("$linha,$coluna" == posicao) {
                    terreno[linha][coluna] = "A"
                }
            }
        }
    }

    return terreno
}

fun criaTerreno(
    terreno:
    Array<Array<String?>>,
    contadoresVerticais: Array<Int?>?,
    contadoresHorizontais: Array<Int?>?,
    mostraLegendaHorizontal: Boolean,
    mostraLegendaVertical: Boolean
): String {
    return ""
}

fun conversao(numero: Int): Char {
    var count = 0
    var resultado = 'A'
    while (count < numero - 1) {
        resultado += 1
        count++
    }
    return resultado
}

fun processaCoordenadas(coordenadasStr: String?, numLines: Int, numColumns: Int): Pair<Int, Int>? {
    val first= 0
    val second = 0

    val coordenadas: Pair<Int, Int>? = Pair(first,second)

    if (coordenadasStr == null) {
        return null
    }
    val tamanho = coordenadasStr.length
    if (tamanho != 3) {
        return null
    }
    val numero = coordenadasStr[0]
    val virgula = coordenadasStr[1]
    val letra = coordenadasStr[2]
    if (numero.digitToInt() > numLines) {
        return null
    } else if (numero.digitToInt() < 1) {
        return null
    } else if (virgula != ',') {
        return null
    } else if (letra !in 'A'..conversao(numColumns)) {
        return null
    }


    return coordenadas
}

fun temArvoreAdjacente(terreno: Array<Array<String?>>, coords: Pair<Int, Int>): Boolean {
    val linha = coords.first
    val coluna = coords.second


    if (coluna + 1 < terreno[0].size) {
        if (terreno[linha][coluna + 1] == "A") {
            return true
        }
    }
    if (linha + 1 < terreno.size) {
        if (terreno[linha + 1][coluna] == "A") {
            return true
        }
    }
    if (linha - 1 >= 0) {
        if (terreno[linha - 1][coluna] == "A") {
            return true
        }
    }
    if (coluna - 1 >= 0) {
        if (terreno[linha][coluna - 1] == "A") {
            return true
        }
    }

    return false
}


fun temTendaAdjacente(terreno: Array<Array<String?>>, coords: Pair<Int, Int>): Boolean {
    val linha = coords.first
    val coluna = coords.second


    if (coluna + 1 < terreno[0].size) {
        if (terreno[linha][coluna + 1] == "T") {
            return true
        }
    }
    if (linha + 1 < terreno.size) {
        if (terreno[linha + 1][coluna] == "T") {
            return true
        }
    }
    if (linha - 1 >= 0) {
        if (terreno[linha - 1][coluna] == "T") {
            return true
        }
    }
    if (coluna - 1 >= 0) {
        if (terreno[linha][coluna - 1] == "T") {
            return true
        }
    }
    if (linha + 1 < terreno.size && coluna + 1 < terreno[0].size) {
        if (terreno[linha + 1][coluna + 1] == "T") {
            return true
        }
    }


    if (linha + 1 < terreno.size && coluna - 1 >= 0) {
        if (terreno[linha + 1][coluna - 1] == "T") {
            return true
        }
    }

    if (linha - 1 <= terreno.size && coluna + 1 > 0) {
        if (terreno[linha -1][coluna +1] == "T") {
            return true
        }
    }

    if (linha - 1 >= 0 && coluna - 1 >= 0) {
        if (terreno[linha-1][coluna - 1] == "T") {
            return true
        }
    }
    return false
}


fun contaTendasColuna(terreno: Array<Array<String?>>, coluna: Int): Int {
    var count = 0
    for (linha in 0 until terreno.size) {
        if (terreno[linha][coluna] == "T") {
            count++
        }
    }
    return count
}


fun contaTendasLinha(terreno: Array<Array<String?>>, linha: Int): Int {
    var count = 0
    for (coluna in terreno.indices) {
        if (terreno[linha][coluna] == "T") {
            count += linha
        }
    }
    return count
}

fun colocaTenda(terreno: Array<Array<String?>>, coords: Pair<Int, Int>): Boolean {
    return false
}

fun terminouJogo(
    terreno: Array<Array<String?>>,
    contadoresVerticais: Array<Int?>,
    contadoresHorizontais: Array<Int?>
): Boolean {
    return true
}

fun criaMenu(): String {
    return "\nBem vindo ao jogo das tendas\n\n1 - Novo jogo\n0 - Sair\n"
}

fun validaTamanhoMapa(numLinhas: Int, numColunas: Int): Boolean {
    if (numLinhas == 6) {
        if (numColunas == 5 || numColunas == 6) {
            return true
        }
    } else if (numLinhas == 8) {
        if (numColunas == 8 || numColunas == 10) {
            return true
        }
    } else if (numLinhas == 10) {
        if (numColunas == 8 || numColunas == 10) {
            return true
        }
    }
    return false
}

fun validaDataNascimento(data: String?): String? {
    if (data != null) {

        if (data.length != 10) {
            return "Data invalida"
        }

        val dia = "${data[0]}${data[1]}".toInt()
        val mes = "${data[3]}${data[4]}".toInt()
        val ano = "${data[6]}${data[7]}${data[8]}${data[9]}".toInt()

        if (data[2] != '-' || data[5] != '-') {
            return "Data invalida"
        }

        if (dia in 1..31) {
            if (mes in 1..12) {
                if (ano in 1900..2022) {
                    if (ano == 2004 && (mes == 11 || mes == 12)) {
                        return "Menor de idade nao pode jogar"
                    }
                    if (ano > 2004) {
                        return "Menor de idade nao pode jogar"
                    }
                    if ((mes == 4 || mes == 6 || mes == 11 || mes == 9) && dia == 31) {
                        return "Data invalida"
                    }
                    if (mes == 2 && dia > 29) {
                        return "Data invalida"
                    }
                    if (mes == 2 && dia == 29 && ano % 4 != 0) {
                        return "Data invalida"
                    }
                    return null
                }
            }
        }
    }

    return "Data invalida"
}

fun criaLegendaHorizontal(numColunas: Int): String {
    var terreno: String = "A"
    var count = 1
    while (count < numColunas) {
        terreno += " | ${'A' + count}"
        count++
    }
    return terreno
}

fun main() {
    val terreno: Array<Array<String?>> = arrayOf(
        arrayOf(" ", " ", " ", " ", " ", " "),
        arrayOf(" ", "T", " ", " ", " ", " "),
        arrayOf(" ", " ", " ", " ", " ", " "),
        arrayOf(" ", " ", " ", " ", " ", " "),
        arrayOf(" ", " ", " ", " ", " ", " "),
        arrayOf(" ", " ", " ", " ", " ", " ")
    )
    println(temTendaAdjacente(arrayOf(arrayOf("T",null, null), arrayOf(null, null, null)), Pair(1,1)))

    println(contaTendasLinha(arrayOf(arrayOf("T", null, null, "T", null)), 1))
}