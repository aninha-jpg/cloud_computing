import { useState } from "react";
import "./matricula.css";

export default function Matricula({ alunoId, cursoId, onMatriculaCriada, onContinuar }) {

    async function criarMatricula(e) {
        e.preventDefault();

        const resposta = await fetch("https://api-matriculas.chilecentral.cloudapp.azure.com/matricula", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                alunoId: alunoId,
                cursoId: cursoId
            })
        });

        if (!resposta.ok) {
            alert("Erro ao realizar matrícula!");
            return;
        }

        const matricula = await resposta.json();

        onMatriculaCriada(matricula.id);
        onContinuar();
    }

    return (
        <section className="cadastro">
            <div className="cadastro-container">

                <span className="cadastro-etapa">
                    ETAPA 03 — MATRÍCULA
                </span>

                <h2>Confirme sua matrícula</h2>

                <p>
                    Os dados do aluno e do curso foram registrados.
                    Clique abaixo para gerar sua matrícula.
                </p>

                <form className="cadastro-form" onSubmit={criarMatricula}>

                    <button type="submit" className="cadastro-button">
                        Gerar matrícula →
                    </button>

                </form>
            </div>
        </section>
    );
}