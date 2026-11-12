
import { useState } from "react";
import "./contrato.css";

export default function Contrato({ matriculaId }) {

    const [htmlConfirmacao, setHtmlConfirmacao] = useState("");

    async function gerarContrato(e) {
        e.preventDefault();

        try {
            const resposta = await fetch(
                "https://api-matriculas.chilecentral.cloudapp.azure.com/contrato",
                {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify({
                        matriculaId: matriculaId,
                        confirmacao: "OK"
                    })
                }
            );

            if (!resposta.ok) {
                alert("Erro ao gerar contrato!");
                return;
            }

            const html = await resposta.text();
            setHtmlConfirmacao(html);

        } catch (erro) {
            console.error("Erro:", erro);
            alert("Não foi possível finalizar a matrícula.");
        }
    }

    return (
        <section className="contrato">
            <div className="contrato-container">

                {htmlConfirmacao ? (
                    <iframe
                        title="Confirmação de matrícula"
                        srcDoc={htmlConfirmacao}
                        style={{
                            width: "100%",
                            minHeight: "350px",
                            border: "none"
                        }}
                    />
                ) : (
                    <>
                        <span>ETAPA 06 — CONTRATO</span>

                        <h2>Finalizar matrícula</h2>

                        <p>
                            Todas as etapas foram concluídas.
                            Confirme para gerar seu contrato e finalizar o processo.
                        </p>

                        <form onSubmit={gerarContrato}>
                            <button type="submit">
                                Gerar contrato →
                            </button>
                        </form>
                    </>
                )}

            </div>
        </section>
    );
}
