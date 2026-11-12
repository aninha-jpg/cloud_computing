import { useState } from "react";
import "./pagamento.css";

export default function Pagamento({ matriculaId, onContinuar }) {

    const [valor, setValor] = useState("");

    async function realizarPagamento(e) {
        e.preventDefault();

        const resposta = await fetch("https://api-matriculas.chilecentral.cloudapp.azure.com/pagamento", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                matriculaId: matriculaId,
                valor: Number(valor),
                confirmacao: "OK"
            })
        });

        if (!resposta.ok) {
            alert("Erro ao realizar pagamento!");
            return;
        }

        alert("Pagamento confirmado!");
        onContinuar();
    }

    return (
        <section className="pagamento">
            <div className="pagamento-container">

                <span>ETAPA 04 — PAGAMENTO</span>

                <h2>Confirme seu pagamento</h2>

                <p>
                    Informe o valor para registrar o pagamento da matrícula.
                </p>

                <form onSubmit={realizarPagamento}>

                    <div className="form-group">
                        <label htmlFor="valor">Valor do pagamento</label>

                        <input
                            type="number"
                            id="valor"
                            value={valor}
                            onChange={(e) => setValor(e.target.value)}
                            placeholder="Ex: 500.00"
                            min="0.01"
                            step="0.01"
                            required
                        />
                    </div>

                    <button type="submit">
                        Confirmar pagamento →
                    </button>

                </form>
            </div>
        </section>
    );
}