# O que é Criptografia?

Criptografia é a prática de proteger informações através da codificação, de modo que apenas aqueles que possuem a chave correta possam decifrá-las. Ela é fundamental para garantir a segurança e a privacidade em muitas áreas da tecnologia, desde a comunicação digital até o armazenamento de dados.

Existem dois principais tipos de criptografia:

- **Criptografia Simétrica**: Usa a mesma chave para criptografar e descriptografar dados.
- **Criptografia Assimétrica**: Usa um par de chaves — uma chave pública para criptografar e uma chave privada para descriptografar.

---

# Como a Criptografia Funciona?

## 1. Cifra de Substituição (Cifra de César)

A **Cifra de César** é um dos algoritmos de criptografia mais antigos, criado por Júlio César. É uma cifra de substituição, o que significa que cada letra no texto é substituída por outra, deslocada por um número fixo de posições no alfabeto. Por exemplo, um deslocamento de 3 faria com que "A" se tornasse "D", "B" se tornasse "E", e assim por diante.

### Exemplo:
- **Texto Original**: "SEGURANCA"
- **Deslocamento (shift)**: 3
- **Texto Criptografado**: "VHJXUDQFD"

Esse método é considerado muito simples e fácil de quebrar, mas foi uma das primeiras formas de proteger mensagens.

---

## 2. Criptografia Simétrica (AES)

A **criptografia simétrica** usa a mesma chave tanto para criptografar quanto para descriptografar os dados. Um exemplo popular é o **AES (Advanced Encryption Standard)**, amplamente utilizado em sistemas de segurança modernos, incluindo redes sem fio (Wi-Fi) e VPNs.

### Funcionamento:
1. Uma chave secreta é gerada.
2. O texto original (plaintext) é convertido em dados criptografados (ciphertext) usando a chave.
3. Para recuperar o texto original, a mesma chave é usada para descriptografar os dados.

### Exemplo:
- **Texto Original**: "SEGURANCA"
- **Chave**: "1234567890abcdef" (128 bits)
- **Texto Criptografado**: "pCr1Y+7FYJKlSZ0i"

---

## 3. Criptografia Assimétrica (RSA)

A **criptografia assimétrica** usa dois tipos de chaves: uma chave pública para criptografar os dados e uma chave privada para descriptografá-los. Um dos algoritmos mais conhecidos para isso é o **RSA (Rivest–Shamir–Adleman)**.

### Funcionamento:
1. O remetente usa a chave pública do destinatário para criptografar a mensagem.
2. Apenas o destinatário, que possui a chave privada correspondente, pode descriptografar a mensagem.

### Exemplo:
- **Texto Original**: "SEGURANCA"
- **Chave Pública**: Utilizada para criptografar
- **Chave Privada**: Utilizada para descriptografar
- **Texto Criptografado**: "Aq1VHY3de4W..."

---

## 4. Funções Hash (SHA-256)

Diferente dos outros tipos de criptografia, as **funções hash** são usadas para verificar a integridade dos dados. Uma função hash transforma uma entrada de dados em uma sequência fixa de comprimento, chamada de hash, de forma que qualquer pequena mudança nos dados altere completamente o valor do hash. **SHA-256** é uma função hash muito utilizada em segurança digital, especialmente em assinaturas digitais e validação de integridade de arquivos.

### Exemplo:
- **Texto Original**: "SEGURANCA"
- **Hash (SHA-256)**: "5593fe367d1d03efc896fbcd283..."

As funções hash são amplamente usadas para armazenar senhas (em vez de armazenar a senha diretamente, armazena-se o hash dela) e garantir que os dados não foram alterados.

---

# Criptografias Comuns e Seus Usos

### Cifra de César:
- **Uso**: Principalmente histórico; demonstração em aulas e aprendizado.
- **Vantagens**: Fácil de entender e implementar.
- **Desvantagens**: Muito fácil de quebrar.

### AES (Advanced Encryption Standard):
- **Uso**: Comunicação segura em redes, armazenamento de dados, criptografia de arquivos e mensagens.
- **Vantagens**: Extremamente seguro e rápido.
- **Desvantagens**: Necessidade de uma chave secreta compartilhada de forma segura.

### RSA (Rivest–Shamir–Adleman):
- **Uso**: Transferência segura de dados, criptografia de e-mails, autenticação digital.
- **Vantagens**: Usa chaves públicas, facilitando a criptografia segura entre dois sistemas.
- **Desvantagens**: Comparado ao AES, é mais lento para grandes volumes de dados.

### SHA-256 (Secure Hash Algorithm):
- **Uso**: Assinaturas digitais, validação de integridade de arquivos, verificação de senhas.
- **Vantagens**: Transformação de dados em valores únicos, detecção de pequenas alterações em arquivos.
- **Desvantagens**: Não é reversível (não pode ser descriptografado).

---

# Importância da Criptografia

A criptografia é essencial para:

- **Proteção de dados**: Garantir que dados sensíveis, como senhas e informações pessoais, não sejam acessados por pessoas não autorizadas.
- **Privacidade**: Manter a confidencialidade das comunicações digitais.
- **Integridade de dados**: Garantir que os dados não sejam alterados durante a transmissão.

Em um mundo cada vez mais digital, o uso adequado da criptografia é um dos pilares da segurança da informação.
