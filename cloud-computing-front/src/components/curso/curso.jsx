import { useState } from "react";
import "./curso.css";

export default function Curso({ onCursoSelecionado, onContinuar }) {

    const [cursos, setCursos] = useState([]);

    async function buscarCursos() {
        const resposta = await fetch("https://api-matriculas.chilecentral.cloudapp.azure.com/curso");

        if (!resposta.ok) {
            alert("Erro ao carregar cursos!");
            return;
        }

        const dados = await resposta.json();
        setCursos(dados);
    }

    function selecionarCurso(curso) {
        onCursoSelecionado(curso.id);
        onContinuar();
    }

    return (
        <section className="curso">
            <div className="curso-container">

                <span>ETAPA 02 — ESCOLHA SEU CURSO</span>

                <h2>Escolha seu curso</h2>

                <button onClick={buscarCursos}>
                    Carregar cursos
                </button>

                {cursos.map((curso) => (
                    <div className="curso-info" key={curso.id}>
                        <h3>{curso.nome}</h3>

                        <button onClick={() => selecionarCurso(curso)}>
                            Selecionar curso →
                        </button>
                    </div>
                ))}

            </div>
        </section>
    );
}