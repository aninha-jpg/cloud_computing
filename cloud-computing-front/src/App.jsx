import { useState } from "react";
import Aluno from "./components/aluno/aluno";
import Curso from "./components/curso/curso";
import Matricula from "./components/matricula/matricula";
import Pagamento from "./components/pagamento/pagamento";
import Contrato from "./components/contrato/contrato";
import Documentacao from "./components/documentacao/documentacao";

function App() {

    const [etapa, setEtapa] = useState(1);

    const [alunoId, setAlunoId] = useState(null);
    const [cursoId, setCursoId] = useState(null);
    const [matriculaId, setMatriculaId] = useState(null);

    return (
        <>

            {etapa === 1 && (
                <Aluno
                    onAlunoCadastrado={setAlunoId}
                    onContinuar={() => setEtapa(2)}
                />
            )}

            {etapa === 2 && (
                <Curso
                    onCursoSelecionado={setCursoId}
                    onContinuar={() => setEtapa(3)}
                />
            )}

            {etapa === 3 && (
                <Matricula
                    alunoId={alunoId}
                    cursoId={cursoId}
                    onMatriculaCriada={setMatriculaId}
                    onContinuar={() => setEtapa(4)}
                />
            )}

            {etapa === 4 && (
                <Pagamento
                    matriculaId={matriculaId}
                    onContinuar={() => setEtapa(5)}
                />
            )}

            {etapa === 5 && (
                <Documentacao
                    matriculaId={matriculaId}
                    onContinuar={() => setEtapa(6)}
                />
            )}
            
            {etapa === 6 && (
                <Contrato matriculaId={matriculaId} />
            )}
        </>
    );
}

export default App;