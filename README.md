
# Examen Mercadolibre

Magneto quiere reclutar la mayor cantidad de mutantes para poder luchar contra los X-Men.
Te ha contratado a ti para que desarrolles un proyecto que detecte si un humano es mutante basándose en su secuencia de ADN.

Para eso te ha pedido crear un programa con un método o función con la siguiente forma:

boolean isMutant(String[] dna); 
// Ejemplo Java

En donde recibirás como parámetro un array de Strings que representan cada fila de una tabla de (NxN) con la secuencia del ADN. Las letras de los Strings solo pueden ser: (A,T,C,G), las cuales representa cada base nitrogenada del ADN.



## API Reference

#### Records the genetic chain of a person and determines whether or not he is a mutant.

```http
  POST /mutant/
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `dna` | `String[]` | **Required**. Genetic chain of a person |

| Request example                |
| :------------------------- |
| `{	"dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTGG"]}` |

| Case | Response     | 
| :-------- | :------- | 
| `Mutant detected and registered` | `{"detail": "Is Mutant","status": "Saved"}` |
| `No mutant detected and registered` | `{"detail": "Isn't Mutant","status": "Saved"}` |
| `Person already registered` | `{"detail": "This person is already registered"}` |
| `Wrong format in DNA sequence` | `{"detail": "Wrong format in DNA sequence"}` |

#### Get stats from mutant population

```http
  GET /stats/
```

| Response example                |
| :------------------------- |
| `{"count_mutant_dna": 1,"count_human_dna": 4,"radio": 0.25}` |





## Author

- [@lgerardocv](https://github.com/lcervantes27)

