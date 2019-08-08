import React from 'react';
import { Badge } from 'reactstrap';
import { faGithub } from '@fortawesome/free-brands-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

export default function Home(props) {
    return (
        <div className="container text-center">
            <h1 className="display-1">Welcome</h1>
            <h4>
                <Badge
                    href="https://github.com/Monika-Mistry/springboot-accountAPI"
                    color="info">
                    <FontAwesomeIcon icon={faGithub} /> GitHub Repository
            </Badge>
            </h4>
        </div>
    )
}