# 1. Criptografia Simétrica com AES (Advanced Encryption Standard)

O AES é um algoritmo de criptografia simétrica que foi escolhido pelo NIST (National Institute of Standards and Technology) para substituir o DES (Data Encryption Standard) em 2001. O AES é um algoritmo de bloco que criptografa e descriptografa dados em blocos de 128 bits usando chaves de 128, 192 ou 256 bits. O AES é amplamente utilizado em todo o mundo e é considerado um dos algoritmos de criptografia mais seguros disponíveis atualmente.

## Explicação do Código:

### Importações:
A biblioteca `javax.crypto` é usada para operações de criptografia, incluindo o uso do algoritmo AES e geração de chaves.

### Função `encrypt`:

- Pega a mensagem original (texto simples) e a transforma em texto criptografado.
- O método `Cipher.getInstance("AES")` cria uma instância do AES.
- `cipher.init(Cipher.ENCRYPT_MODE, key)` inicializa o cifrador no modo de criptografia.
- `doFinal(data.getBytes())` executa a criptografia nos dados.
- Os bytes criptografados são codificados em Base64 (para que possam ser armazenados como texto legível).

### Função `decrypt`:

- Reverte o processo de criptografia, descriptografando os dados.
- Usa o modo `Cipher.DECRYPT_MODE` para descriptografar.
- Converte o texto Base64 de volta para bytes, e então os descriptografa.

### Geração de Chave:

- `KeyGenerator.getInstance("AES")` cria um gerador de chaves AES.
- `keyGen.init(128)` define o tamanho da chave (128 bits neste caso).
- `secretKey = keyGen.generateKey()` gera uma chave AES.

### Processo no `main`:

- O texto original "SegurancaDaInformacao" é criptografado com a chave gerada.
- O texto criptografado é então descriptografado usando a mesma chave.

---

# 2. Criptografia Assimétrica com RSA (Rivest–Shamir–Adleman)

O RSA é um algoritmo de criptografia assimétrica que foi inventado por Ron Rivest, Adi Shamir e Leonard Adleman em 1977. O RSA é baseado na dificuldade de fatorar números inteiros grandes em seus fatores primos. O RSA é amplamente utilizado para criptografia de chaves públicas.

## Explicação do Código:

### Função `encrypt`:

- Criptografa os dados usando a chave pública.
- `Cipher.getInstance("RSA")` cria uma instância do algoritmo RSA.
- `cipher.init(Cipher.ENCRYPT_MODE, publicKey)` inicializa o cifrador no modo de criptografia com a chave pública.
- Os dados são criptografados e convertidos em Base64.

### Função `decrypt`:

- Descriptografa os dados usando a chave privada.
- `cipher.init(Cipher.DECRYPT_MODE, privateKey)` inicializa o cifrador no modo de descriptografia com a chave privada.
- Descriptografa os dados criptografados de volta para o formato original.

### Geração do Par de Chaves:

- `KeyPairGenerator.getInstance("RSA")` cria um gerador de chaves RSA.
- `keyGen.initialize(2048)` define o tamanho da chave (2048 bits).
- `KeyPair pair = keyGen.generateKeyPair()` gera o par de chaves (pública e privada).

### Processo no `main`:

- O texto "SegurancaDaInformacao" é criptografado com a chave pública.
- O texto criptografado é descriptografado com a chave privada.

---

# 3. Tentativa de Quebra por Força Bruta (AES)

O código também inclui uma tentativa de quebra por força bruta do AES. Neste caso, a chave é gerada aleatoriamente e o texto criptografado é descriptografado usando todas as possíveis chaves até encontrar a chave correta. Este método é extremamente ineficiente e impraticável para chaves de tamanho razoável (128 bits ou mais).

## Explicação do código:

### Função `decryptWithKey`:

- Descriptografa os dados com uma chave AES fornecida.
- Usa o `SecretKeySpec` para definir a chave AES.
- Os dados criptografados são descriptografados e retornados como texto.

### Função `bruteForce`:

- Realiza uma tentativa de "força bruta" para quebrar a criptografia AES.
- Tenta todas as combinações de chaves de 3 caracteres, preenchendo os demais caracteres da chave para formar uma chave de 16 bytes.
- Se o texto descriptografado contiver a parte conhecida (`knownPart`), ele exibe a chave encontrada.

### Processo no `main`:

- Recebe os dados criptografados e uma parte conhecida do texto original.
- A função `bruteForce` tenta todas as combinações de chaves para encontrar a correta.
