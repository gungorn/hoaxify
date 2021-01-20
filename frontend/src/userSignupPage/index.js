import React from 'react';
import axios from 'axios';

class UserSignupPage extends React.Component {
	state = {
		username: '',
		displayname: '',
		password: '',
		password2: '',
		agree: false
	};

	componentDidMount() { }
	componentDidUpdate(prevProps, prevState) { }
	componentWillUnmount() { }

	onChange = ({ target }) => { this.setState({ [target.name]: target.value }); };
	// onChangeUsername = ({ target }) => { this.setState({ username: target.value }); };
	// onChangeDisplayname = ({ target }) => { this.setState({ displayname: target.value }); };
	// onChangePassword = ({ target }) => { this.setState({ password: target.value }); };
	// onChangePassword2 = ({ target }) => { this.setState({ password2: target.value }); };
	// onChangeAgrement = ({ target }) => { this.setState({ agree: target.checked }); };


	onClickSignup = d => {
		d.preventDefault();

		const body = {
			username: this.state.username,
			displayname: this.state.displayname,
			password: this.state.password
		};

		axios.post('/api/v1/users', body)
			.then(res => console.log(res))
			.catch(e => console.log(e));
	};

	render() {
		return (
			<form>
				<h1>Signup Page</h1>

				<div>
					<label>Username</label>
					<input
						name="username"
						value={this.state.username}
						onChange={this.onChange}
					/>
				</div>

				<div>
					<label>Display Name</label>
					<input
						name="displayname"
						value={this.state.displayname}
						onChange={this.onChange}
					/>
				</div>

				<div>
					<label>Pasword</label>
					<input
						name="password"
						type="password"
						value={this.state.password}
						onChange={this.onChange}
					/>
				</div>

				<div>
					<label>Repeat Pasword</label>
					<input
						name="password2"
						type="password"
						value={this.state.password2}
						onChange={this.onChange}
					/>
				</div>

				<div>
					<label>Agrement</label>
					<input
						name="agree"
						type="checkbox"
						value={this.state.agree}
						onChange={this.onChange}
					/>
				</div>

				<button
					//disabled={!this.state.agree}
					onClick={this.onClickSignup}
				>
					Sign Up
				</button>
			</form>
		);
	}
}

export { UserSignupPage };
