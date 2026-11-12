import { useState } from "react";
import "./aluno.css";

export default function Aluno({ onAlunoCadastrado, onContinuar }) {

    const [nome, setNome] = useState("");
    const [email, setEmail] = useState("");

    async function cadastrarAluno(e) {
        e.preventDefault();

        const resposta = await fetch("https://api-matriculas.chilecentral.cloudapp.azure.com/aluno", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({ nome, email })
        });

        if (!resposta.ok) {
            alert("Erro ao cadastrar aluno!");
            return;
        }

        const aluno = await resposta.json();

        onAlunoCadastrado(aluno.id);
        onContinuar();
    }

    return (
        <section className="cadastro" id="matricula">
            <div className="cadastro-container">

                <span className="cadastro-etapa">
                    ETAPA 01 — DADOS PESSOAIS
                </span>

                <h2>Vamos começar?</h2>

                <p>
                    Informe seus dados para iniciar sua matrícula.
                </p>

                <form className="cadastro-form" onSubmit={cadastrarAluno}>

                    <div className="form-group">
                        <label htmlFor="nome">Nome completo</label>
                        <input
                            type="text"
                            id="nome"
                            value={nome}
                            onChange={(e) => setNome(e.target.value)}
                            placeholder="Digite seu nome completo"
                            required
                        />
                    </div>

                    <div className="form-group">
                        <label htmlFor="email">E-mail</label>
                        <input
                            type="email"
                            id="email"
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                            placeholder="seuemail@email.com"
                            required
                        />
                    </div>

                    <button type="submit" className="cadastro-button">
                        Continuar →
                    </button>

                </form>
            </div>
        </section>
    );
}