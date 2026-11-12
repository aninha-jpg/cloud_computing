import "./documentacao.css";

export default function Documentacao({ matriculaId, onContinuar }) {

    async function enviarDocumentacao(e) {
        e.preventDefault();

        const resposta = await fetch("https://api-matriculas.chilecentral.cloudapp.azure.com/documentacao", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                matriculaId: matriculaId,
                confirmacao: "OK"
            })
        });

        if (!resposta.ok) {
            alert("Erro ao registrar documentação!");
            return;
        }

        alert("Documentação registrada com sucesso!");
        onContinuar();
    }

    return (
        <section className="documentacao">
            <div className="documentacao-container">

                <span>ETAPA 05 — DOCUMENTAÇÃO</span>

                <h2>Documentação</h2>

                <p>
                    Confirme o envio da documentação necessária para continuar
                    com sua matrícula.
                </p>

                <form onSubmit={enviarDocumentacao}>
                    <button type="submit">
                        Confirmar documentação →
                    </button>
                </form>

            </div>
        </section>
    );
}